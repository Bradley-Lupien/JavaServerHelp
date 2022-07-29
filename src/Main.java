public class Main {
    public static void main(String[] args) {
        Order order = Order.getOrder();
        order.showBill(order);
    }
}
