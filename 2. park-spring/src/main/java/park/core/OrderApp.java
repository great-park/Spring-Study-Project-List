package park.core;

import park.core.member.Grade;
import park.core.member.Member;
import park.core.member.MemberService;
import park.core.member.MemberServiceImpl;
import park.core.order.Order;
import park.core.order.OrderService;
import park.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        // MemoryMemberRepository, FixDiscountPolicy 의존 관계가 주입된 orderServiceImpl이 담김
        OrderService orderService = appConfig.orderService();

        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
