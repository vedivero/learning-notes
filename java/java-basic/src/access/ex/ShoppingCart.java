package access.ex;

public class ShoppingCart {

    private Item[] items = new Item[10];
    private int itemCount = 0;

    public void addItem(Item item) {

        if (items.length <= itemCount) {
            System.out.println("장바구니가 꽉 찼습니다");
            return;
        }
        System.out.println("장바구니에 상품이 추가 되었습니다");
        items[itemCount] = item;
        itemCount++;
    }

    public void displayItems() {
        System.out.println("=== 장바구니 목록 ===");
        for (int i = 0; i < itemCount; i++) {
            Item item = items[i];
            System.out.println("상품명 : " + item.getName() + ", 합계 : "+item.getTotalPrice());
        }
        System.out.println("전체 가격 : "+calculateTotalPrice());
    }

    private int calculateTotalPrice() {
        int totalPrice = 0;
        for (int i = 0; i < itemCount; i++) {
            Item item = items[i];
            totalPrice += item.getTotalPrice();
        }
        return totalPrice;
    }
}
