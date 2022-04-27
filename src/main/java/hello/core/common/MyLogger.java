package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
// proxyMode = ScopedProxyMode.TARGET_CLASS를 사용하면 의존성 주입 때 가짜 proxy 객체를 먼저 넣어놓고
// 실제 로직이 들어왔을 때 진짜를 찾아서 반환한다
public class MyLogger {

  private String uuid;
  private String requestURL;

  public void setRequestURL(String requestURL) {
    this.requestURL = requestURL;
  }

  public void log(String message) {
    System.out.println("[" + uuid + "] " + "[" + requestURL + "] " + message);
  }

  @PostConstruct
  public void init() {
    uuid = UUID.randomUUID().toString();
    System.out.println("[" + uuid + "] request scope bean create:" + this);
  }

  @PreDestroy
  public void close() {
    System.out.println("[" + uuid + "] request scope bean closed:" + this);
  }
}
