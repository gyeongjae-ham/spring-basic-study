package hello.core.order;

// OrderService interface 작성

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
