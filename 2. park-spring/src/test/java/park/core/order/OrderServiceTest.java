package park.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import park.core.member.Grade;
import park.core.member.Member;
import park.core.member.MemberService;
import park.core.member.MemberServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();
    @Test
    void createOrder() {
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}