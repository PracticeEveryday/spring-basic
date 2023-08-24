package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService{
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // 할인 정책을 변경하기 위해서 OrserServiceImpl 코드를 수정하는 일이 벌어진다 ㅠ
    // 구현 클래스에도 의존하고 있다 구현체를 변경한느 순간 OCP가 터진다.!!
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
//private final MemberRepository memberRepository = new MemoryMemberRepository();


    // OCP, DIP 성공!
    // memberRepository가 memory에서 가져오든, db에서 가져오든 내 관심사가 아니고 레포지토리가 하는 역할만 생각하면 된다!
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);

        // 섫계가 잘된 이유 -> OrderService 입장에서는 할인에 대한 거는 아무것도 몰라 discountPolicy 너가 알아서 하고 할인에 대한 결과를 줘!
        // 단일 책임의 원칙이 잘 되어 있다!
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
