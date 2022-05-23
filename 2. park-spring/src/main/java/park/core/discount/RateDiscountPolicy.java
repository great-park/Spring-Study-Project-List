package park.core.discount;
import org.springframework.stereotype.Component;
import park.core.annotation.MainDiscountPolicy;
import park.core.member.Grade;
import park.core.member.Member;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {
    private int discountPercent = 10; //10% 할인
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}