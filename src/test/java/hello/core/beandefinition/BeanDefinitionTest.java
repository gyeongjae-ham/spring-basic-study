package hello.core.beandefinition;


import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanDefinitionTest {

    //    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    // 이건 직접 빈을 등록하기 때문에 명확하게 클래스 네임이 들어간 방면 위의 코드는 팩토리 메서드 방식으로
    // 클래스에서는 드러나지 않고 팩토리 메서드 부분에서 메서드 네임이 드러난다
    GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");

    // BeanDefinition은 Definition Reader들이 각 읽는 방식에 따라 생성하는 빈의 메타 정보이다
    // 이 메타정보를 기반으로 실제 인스턴스를 생성할 수 있다
    @Test
    @DisplayName("빈 설정 메타정보 확인 - BeanDefinition 확인하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitionName = " + beanDefinitionName + " beanDefinition = " + beanDefinition);
            }
        }
    }
}
