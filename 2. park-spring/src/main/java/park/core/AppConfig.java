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


@Configuration
public class AppConfig {

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository()
    // 싱글톤 위반?? -> 스프링 컨테이너가 해결해줌

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
        return new RateDiscountPolicy();
    }
}
