package hello.core.member;

public class MemberServiceImpl implements MemberService {

  private final MemberRepository memberRepository;

  public MemberServiceImpl(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @Override
  public void join(Member member) {
    memberRepository.save(member);
  }

  @Override
  public Member findMember(Long memberId) {
    return memberRepository.findById(memberId);
  }

  // 테스트 용도(@Configuration이 싱글톤 유지하는지)
  public MemberRepository getMemberRepository() {
    return memberRepository;
  }
}
