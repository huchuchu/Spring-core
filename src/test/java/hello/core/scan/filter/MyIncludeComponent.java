package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE) //TYPE : class 레벨에 붙음
@Retention(RetentionPolicy.RUNTIME)
@Documented
// 얘가 붙으면 Component 스캔 대상
public @interface MyIncludeComponent {
}
