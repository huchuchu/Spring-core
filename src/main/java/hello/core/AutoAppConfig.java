package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// @Component가 붙은 class를 찾아서 bean으로 등록해준다
// @Configuration 가 붙은 class는 빼고 등록
@ComponentScan (
/*      모든 자바 클래스틑 다 컴포넌트 스캔하면 시간이 오래걸리기때문에 필요한 위치부터 탐색하도록 시작위치를 지정할 수 있다.(라이브러리도 스캔대상임)
        basePackages = "hello.core.member",
        지정한 클래스의 패키지를 탐색 시작 위치로 지정한다.
        basePackageClasses = AutoAppConfig.class,
        지정하지 않으면 :: @ComponentScan를 붙인 클래스를 시작으로 해당클래스와 하위 클래스를 스캔한다!!  */
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {

}
