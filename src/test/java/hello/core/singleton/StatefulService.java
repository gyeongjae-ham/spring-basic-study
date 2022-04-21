package hello.core.singleton;

// 이렇게 생성하면 안된다는 걸 보여주는 테스트입니다
// 싱글톤은 상태를 가지면 안됩니다!!
public class StatefulService {

    private int price; // 상태를 유지하는 필드 10,000원에서 -> 20,000원으로 바뀌어 버림;;

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; // 여기가 문제!!!!!
    }

    public int getPrice() {
        return price;
    }
}
