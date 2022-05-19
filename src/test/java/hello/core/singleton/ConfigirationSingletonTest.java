package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ConfigirationSingletonTest {

    @Test
    void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        //셋 다 같은 인스턴스!!!
        System.out.println("memberService -> memberRepository1 = " + memberRepository1);
        System.out.println("orderService -> memberRepository2 = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);

        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);

        //@Configuration 지움
/*        memberService -> memberRepository1 = hello.core.member.MemoryMemberRepository@22f31dec
          orderService -> memberRepository2 = hello.core.member.MemoryMemberRepository@34c01041
          memberRepository = hello.core.member.MemoryMemberRepository@76f4b65
*/
        //return new OrderServiceImpl(memberRepository(), discountPolicy()); memberRepository(), discountPolicy() 는 스프링의 관리대상이 아니다!!

    }

    @Test
    void configurationDeep(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
        //[1]
        // 기댓값 : class hello.core.AppConfig
        //bean = class hello.core.AppConfig$$EnhancerBySpringCGLIB$$a86a580b

        //[2]
        //@Configuration 주석처리
        //bean = class hello.core.AppConfig
        // memberRepository 세번 호출 됨 ==> 싱글톤 깨!!짐!!


    }

}
