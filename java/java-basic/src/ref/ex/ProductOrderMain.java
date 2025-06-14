package ref.ex;

public class ProductOrderMain {
    public static void main(String[] args) {
       ProductOrder[] orders = new ProductOrder[3];

        orders[0] = createProductOrder("두부", 2000, 5);
        orders[1] = createProductOrder("콜라", 3000, 3);
        orders[2] = createProductOrder("우유", 4000, 5);

        printProductOrder(orders);
        getTotalAmount(orders);

    }

    static ProductOrder createProductOrder(String productName,int price, int quantity) {
        ProductOrder order = new ProductOrder();
        order.productName = productName;
        order.price = price;
        order.quantity = quantity;
        return order;
    }

    static void printProductOrder(ProductOrder[] orders) {

        for (ProductOrder order : orders) {
            System.out.println("상품명 : " + order.productName + ", 가격 : " + order.price + ", 수량 : " + order.quantity);
        }
    }

    static int getTotalAmount(ProductOrder[] orders) {
        int amount = 0;
        for (ProductOrder order : orders) {
            amount += order.price * order.quantity;
        }
        System.out.println("총 가격 = " + amount);
        return amount;
    }
}
