package hello.core.AutoWired;


import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutoWiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    // 주입할 스프링 빈이 없어도 동작해야 할 때가 있다.
    static class TestBean{
        //(required = false) 설정 해 놓으면 주입 대상이 없을경우 메소드 자체가 호출되지않는다
        @Autowired(required = false)
        public void setNoBean1(Member member){
            System.out.println("setNoBean1 = " + member);
        }

        //@Nullable : null인것도 확인 할 수 있다  setNoBean2 = null
        @Autowired
        public void setNoBean2(@Nullable Member member){
            System.out.println("setNoBean2 = " + member);
        }

        // Optional<Member> : null일 경우 Optional.empty를 반환한다
        @Autowired
        public void setNoBean3(Optional<Member> member){
            System.out.println("setNoBean3 = " + member);
        }

    }
}
