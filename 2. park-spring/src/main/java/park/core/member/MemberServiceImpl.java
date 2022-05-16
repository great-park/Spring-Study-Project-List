package park.core.member;

public class MemberServiceImpl implements MemberService{

    // MemberServiceImpl는 (추상화)MemberRepository도 의존하고, 구현체인 MemmoryMemberRepository도 의존하기 때문에 원칙에  DIP 위배!
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void join(Member member) {
        memberRepository.save(member);
    }

    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
