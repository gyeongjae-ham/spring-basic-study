package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
    excludeFilters =
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
// 보통 실무에서 ANNOTATION과 Configuration을 제외하진 않는다
// 지금은 제외 없이 진행하면 이전 config한 파일 예제들이 다 등록되기 때문에 제외한 것이다.
// ComponentScan은 @Component 애노테이션이 붙은 클래스를 찾아서 스프링 빈으로 등록해준다
public class AutoAppConfig {}
