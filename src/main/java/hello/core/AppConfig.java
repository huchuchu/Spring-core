package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

// 구체적인 객체를 생성하고 연결한다
public class AppConfig {
    
    // 역할과 구현을 한번에 확인 할 수 있다

    //memberService 역할
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    //orderService 역할
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    //memberRepository 역할
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    //discountPolicy 역할
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
    return new RateDiscountPolicy();
    }


}