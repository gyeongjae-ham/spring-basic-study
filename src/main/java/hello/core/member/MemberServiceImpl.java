package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

  private final MemberRepository memberRepository;

  // @ComponentScan이 자동으로 스프링 빈을 등록하는데 어떻게 의존관계를 주입해주지(어디서 설정하는거지?)
  // 바로 구현체를 빈으로 등록해버리는 거 아냐..?
  // @Autowired를 생성자에 붙여주면 MemberRepository를 만드는 파일을 찾아서 자동으로 의존관계를 주입해준다!!!
  // 미친 기능..!!!!
  @Autowired
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
