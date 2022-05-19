package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    // 요청을 할 때마다 객체를 계속 만든다 -> 비효율적, 메모리 낭비가 심하다
    // 해결방안 :  객체가 딱 한개만 생성되고 공유하도록 설계한다(= 싱글톤패턴)
    @Test
    @DisplayName("스프링 없는 순수한한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        //1. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        //2. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        // 참조값이 다른것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //memberService1 =/= memberService2
        assertThat(memberService1).isNotEqualTo(memberService2);
    }

/*    public static void main(String[] args) {
       // SingletonService singletonService  = new SingletonService();
       //'SingletonService()' has private access in 'hello.core.singleton.SingletonService'
    }*/


    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest(){
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        // 같은 객체 인스턴스 반환
        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);
        singletonService1.logic();

        assertThat(singletonService1).isSameAs(singletonService2);
        // isSameAs : == (참조비교)
        // isEqualTo : XX.equal

    }
    // AppConfig를 다 싱글톤 패턴으로 바꿔주어야하나? ==>
    // SpringContainer가 객체를 다 싱글톤으로 알아서 관리해준다!!

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContaioner(){

//        AppConfig appConfig = new AppConfig();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        //1. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);

        //2. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        // 참조값이 다른것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //memberService1 == memberService2
        assertThat(memberService1).isSameAs(memberService2);

    }





}
