package park.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import park.core.member.Grade;
import park.core.member.Member;
import park.core.member.MemberService;
import park.core.member.MemberServiceImpl;


public class MemberApp {

    public static void main(String[] args) {
        //스프링은 항상 ApplicationContext로 시작. 스프링 컨테이너임
        //AnnotationConfigApplicationContext 파라미터로 AppConfig를 넘기면 해당 정보를 토대로 관리해줌
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);


        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);


        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
