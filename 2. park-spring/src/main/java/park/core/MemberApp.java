package park.core;

import park.core.member.Grade;
import park.core.member.Member;
import park.core.member.MemberService;



public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        // MemberServiceImpl이 들어가면서 MemoryMemberRepository 참조값도 넘김(나는 이것을 쓸거야) 주입!
        MemberService memberService = appConfig.memberService();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
