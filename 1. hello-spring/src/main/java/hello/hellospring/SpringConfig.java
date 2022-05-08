package hello.hellospring;
import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    //injection
    //스프링 컨테이너에서 MemberRepository를 찾는데, SpringDataJpaRepository 인터페이스를
    //등록했기 때문에 스프링 데이터 jpa가 자동으로 구현체를 생성하고 스프링 bean에 등록함
   @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

}