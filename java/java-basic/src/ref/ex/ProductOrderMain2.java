package ref.ex;

import java.util.Scanner;

public class ProductOrderMain2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("입력할 주문의 개수를 입력하세요.");
        int orderNum = scanner.nextInt();
        ProductOrder[] orders = new ProductOrder[orderNum];
        scanner.nextLine();

        for (int i = 0; i < orderNum; i++) {
            System.out.println((i+1) + "번째 주문 정보를 입력하세요");
            System.out.print("상품명 : ");
            String name = scanner.nextLine();
            System.out.print("가격 : ");
            int price = scanner.nextInt();
            System.out.print("수량 : ");
            int qty = scanner.nextInt();

            scanner.nextLine();

            orders[i] = createProductOrder(name, price, qty);
        }

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
