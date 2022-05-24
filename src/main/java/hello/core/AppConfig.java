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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// @Bean MemberService -> new MemoryMemberRepository()
// @Bean OrderService -> new MemoryMemberRepository()
// ==> MemoryMemberRepository 가 두번 호출된다. 싱글톤이 깨지는걸까?!?!

// Call AppConfig.memberService
// Call AppConfig.memberRepository
// Call AppConfig.orderService
//==> 한번씩만 Call 된다

// 구체적인 객체를 생성하고 연결한다
@Configuration
public class AppConfig {
    
    // 역할과 구현을 한번에 확인 할 수 있다
    //memberService 역할
    @Bean
    public MemberService memberService(){
        System.out.println("Call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    //orderService 역할
    @Bean
    public OrderService orderService(){
        System.out.println("Call AppConfig.orderService");
//        return new OrderServiceImpl(memberRepository(), discountPolicy());
        return null;
    }

    //memberRepository 역할
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("Call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    //discountPolicy 역할
    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
    return new RateDiscountPolicy();
    }


}
