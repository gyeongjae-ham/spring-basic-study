package hello.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreApplication {

  // 스프링 부트가 기본적으로 변경된 게 수동 등록 빈과 자동 등록 빈이 중복될 경우
  // 기본적으로 오류를 발생하도록 기본 값을 바꾸었다!!
  public static void main(String[] args) {
    SpringApplication.run(CoreApplication.class, args);
  }
}
