package park.core.order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import park.core.discount.DiscountPolicy;
import park.core.discount.FixDiscountPolicy;
import park.core.discount.RateDiscountPolicy;
import park.core.member.Member;
import park.core.member.MemberRepository;
import park.core.member.MemoryMemberRepository;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //private final DiscountPolicy discountPolicy; 로 변경하면  null pointer exception 발생생

   @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}