package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {
//    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 추상(인터페이스)DiscountPolicy뿐만 아니라 구체(구현)클래스FixDiscountPolicy에도 의존하고 있다. -> DIP 위반
     * private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
     * FixDiscountPolicy -> RateDiscountPolicy -> OCP 위반
     * private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
     * */

    /**
     * DIP를 지키면?
     */
//    private final DiscountPolicy discountPolicy;

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
