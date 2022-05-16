package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        // (1)ApplicationContext : spring container라고 보면 된다
        // -> 객체들을 관리해줌!! @Bean 붙은 객체들
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // (2) 객체를 스프링컨테이너를 통해서 찾아와야함!
        // 보통 name은 메소드 이름으로 지정한다
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

//        MemberService memberService = new MemberServiceImpl(memberRepository);
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member fineMember = memberService.findMember(1L);

        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + fineMember.getName());

    }
}
