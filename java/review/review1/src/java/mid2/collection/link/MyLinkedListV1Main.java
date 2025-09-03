package java.mid2.collection.link;

public class MyLinkedListV1Main {

    public static void main(String[] args) {

        MyLinkedListV1 myLinkedListV1 = new MyLinkedListV1();

        System.out.println(" ");
        System.out.println("데이터 추가");
        myLinkedListV1.add("A");
        myLinkedListV1.add("B");
        myLinkedListV1.add("C");
        System.out.println("myLinkedListV1 = " + myLinkedListV1);

        System.out.println(" ");
        System.out.println("기능 사용하기");
        System.out.println("myLinkedListV1.size() = " + myLinkedListV1.size());

        System.out.println(" ");
        System.out.println("myLinkedListV1.get(1) = " + myLinkedListV1.get(1));

        System.out.println(" ");
        System.out.println("myLinkedListV1.indexOf('A') = " + myLinkedListV1.indexOf("A"));

        System.out.println(" ");
        System.out.println("myLinkedListV1.set(0, 'Z') = " + myLinkedListV1.set(0, "Z"));
        System.out.println("myLinkedListV1 = " + myLinkedListV1);

        System.out.println(" ");
        System.out.println("범위 초과");
        myLinkedListV1.add("D");
        myLinkedListV1.add("E");
        myLinkedListV1.add("F");
        System.out.println("myLinkedListV1 = " + myLinkedListV1);
    }
}
