package collection.link;


public class MyLinkedListV1Main {

    public static void main(String[] args) {

        MyLinkedListV1 list = new MyLinkedListV1();
        System.out.println("=== 데이터 추가 ===");
        System.out.println("list = " + list);
        list.add("a");
        System.out.println("list = " + list);
        list.add("b");
        System.out.println("list = " + list);
        list.add("c");
        System.out.println("list = " + list);

        System.out.println("=== 기능 사용===");
        System.out.println("list.size() = " + list.size());
        System.out.println("list.get(1) = " + list.get(1));
        System.out.println("list.indexOf('c') = " + list.indexOf("c"));
        System.out.println("list.set(2,'z') = " + list.set(2, 'z'));
        System.out.println("list = " + list);
        list.add("d");
        System.out.println("list = " + list);
        list.add("e");
        System.out.println("list = " + list);

        //범위 초과, capacity가 늘어나지 않으면 예외 발생
        list.add("f");
        System.out.println("list = " + list);
    }
}
