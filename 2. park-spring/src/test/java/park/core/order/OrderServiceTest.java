package park.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import park.core.AppConfig;
import park.core.member.Grade;
import park.core.member.Member;
import park.core.member.MemberService;
import park.core.member.MemberServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }
}