package park.core;
import park.core.discount.DiscountPolicy;
import park.core.discount.FixDiscountPolicy;
import park.core.discount.RateDiscountPolicy;
import park.core.member.MemberRepository;
import park.core.member.MemberService;
import park.core.member.MemberServiceImpl;
import park.core.member.MemoryMemberRepository;
import park.core.order.OrderService;
import park.core.order.OrderServiceImpl;
public class AppConfig {
    // MemberServiceImpl이 추상화에만 의존할 수 있도록 변경
    //생성자 주입

    //누군가 MemberService를 부르면, MemoryMemberRepository 객체를 생성하고
    //생성한 객체 인스턴스의 참조값을 넘겨 주어 생성자를 통해 주입해준다.
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
