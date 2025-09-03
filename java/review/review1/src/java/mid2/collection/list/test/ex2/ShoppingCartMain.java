package java.mid2.collection.list.test.ex2;

public class ShoppingCartMain {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("삼겹살", 12_000, 3);
        Item item2 = new Item("라면", 3_000, 10);

        cart.addItem(item1);
        cart.addItem(item2);

        cart.displayItems();
    }
    
}
