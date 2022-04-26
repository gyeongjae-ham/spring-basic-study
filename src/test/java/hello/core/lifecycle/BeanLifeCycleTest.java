package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

  @Test
  public void lifeCycleTest() {
    ConfigurableApplicationContext ac =
        new AnnotationConfigApplicationContext(LifeCycleConfig.class);
    NetworkClient client = ac.getBean(NetworkClient.class);
    ac.close();
  }

  // 실행해 보면 url이 초기화되기 전에 메서드들이 호출되므로 url 값이 다 null로 나오게 된다
  @Configuration
  static class LifeCycleConfig {
    @Bean
    public NetworkClient networkClient() {
      NetworkClient networkClient = new NetworkClient();
      networkClient.setUrl("http://hello-spring.dev");
      return networkClient;
    }
  }
}
