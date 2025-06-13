package class1.ex;

public class ProductOrderMain {
    public static void main(String[] args) {
        ProductOrder[] productOrders = new ProductOrder[3];

        ProductOrder product1 = new ProductOrder();
        product1.productName = "두부";
        product1.price = 2000;
        product1.quantity = 5;
        productOrders[0] = product1;

        ProductOrder product2 = new ProductOrder();
        product2.productName = "콜라";
        product2.price = 3000;
        product2.quantity = 3;
        productOrders[1] = product2;

        ProductOrder product3 = new ProductOrder();
        product3.productName = "우유";
        product3.price = 4000;
        product3.quantity = 6;
        productOrders[2] = product3;

        int amount = 0;
        for (ProductOrder productOrder : productOrders) {
            System.out.println("상품명 : " + productOrder.productName + ", 가격 : " + productOrder.price + ", 수량 : " + productOrder.quantity);
            amount += productOrder.price * productOrder.quantity;
        }

        System.out.println("총 가격 = " + amount);

    }
}
