package hello.core.singleton;

public class SingletonService {

    // static으로 처음에 인스턴스를 생성해서 참조변수에 담아둔다
    private static final SingletonService instance = new SingletonService();

    // getInstance를 통해서 생성해 둔 인스턴스만 부를수 있다
    public static SingletonService getInstance() {
        return instance;
    }

    // private으로 생성자를 지정했기 때문에 외부에서 호출할 수 없다
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
