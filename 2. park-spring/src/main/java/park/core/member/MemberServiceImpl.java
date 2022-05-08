package park.core.member;

public class MemberServiceImpl implements MemberService{

    // MemberServiceImpl는 (추상화)MemberRepository도 의존하고, 구현체인 MemmoryMemberRepository도 의존하기 때문에 원칙에  DIP 위배!
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
