package collection.map.test.cart;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> cartMap = new HashMap<>();

    public void add(Product product, int qty) {
        int existingQuantity = cartMap.getOrDefault(product, 0);
        cartMap.put(product, existingQuantity + qty);
    }

    public void minus(Product product, int qty) {
        int existingQuantity = cartMap.getOrDefault(product, 0);

        int newQuantity = existingQuantity - qty;
        if (newQuantity <= 1) {
            cartMap.remove(product);
        } else {
            cartMap.put(product, newQuantity);
        }
    }

    public void printAll() {
        System.out.println(" ");
        System.out.println("장바구니 목록");
        for (Map.Entry<Product, Integer> entry : cartMap.entrySet()) {
            System.out.println("상품명 : " + entry.getKey() + ", 수량 : " + entry.getValue());
        }
    }
}
