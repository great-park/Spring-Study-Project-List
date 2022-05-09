package park.core;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import park.core.discount.DiscountPolicy;
import park.core.discount.FixDiscountPolicy;
import park.core.discount.RateDiscountPolicy;
import park.core.member.MemberRepository;
import park.core.member.MemberService;
import park.core.member.MemberServiceImpl;
import park.core.member.MemoryMemberRepository;
import park.core.order.OrderService;
import park.core.order.OrderServiceImpl;

// 설정 정보에 Configuration 어노테이션을 붙인다.
@Configuration
public class AppConfig {

    // 각 메소드에 Bean을 붙여서 이것들이 스프링 컨테이너에 등록이 된다.

    //key : memberService, value : MemberServiceImpl(memberRepository) 로 스프링 컨테이너에 등록록
   @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
