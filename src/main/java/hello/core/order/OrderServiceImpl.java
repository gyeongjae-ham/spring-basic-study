package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

// OrderService의 구현체 OrderServiceImpl 생성

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

  private final MemberRepository memberRepository; // 뭐가 들어올 지 얘는 모름
  private final DiscountPolicy discountPolicy; // 뭐가 들어올 지 얘는 모름

  // @ComponentScan이 자동으로 스프링 빈을 등록하는데 어떻게 의존관계를 주입해주지(어디서 설정하는거지?)
  // 바로 구현체를 빈으로 등록해버리는 거 아냐..?
  // @Autowired를 생성자에 붙여주면 MemberRepository, DiscountPolicy를 만드는 파일을 찾아서 자동으로 의존관계를 주입해준다!!!
  // 미친 기능..!!!!
  // 생성자가 딱 1개만 있을 경우 @Autowired를 생략할 수 있다

  // OrderService의 메서드 구현
  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId); // memberRepo에서 member 찾아오고
    int discountPrice =
        discountPolicy.discount(
            member, itemPrice); // 할인 정책(정액 할인)에 member 정보와 item 가격 정보 넘겨서(Grade 확인 후) 할인 가격 리턴 받기

    return new Order(memberId, itemName, itemPrice, discountPrice); // 새로운 주문 생성
  }

  // 테스트 용도(@Configuration이 싱글톤 유지하는지)

  public MemberRepository getMemberRepository() {
    return memberRepository;
  }
}
