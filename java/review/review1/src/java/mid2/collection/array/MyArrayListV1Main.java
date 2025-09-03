package java.mid2.collection.array;

public class MyArrayListV1Main {

    public static void main(String[] args) {

        MyArrayListV1 list = new MyArrayListV1();
        System.out.println(" ");
        System.out.println("데이터 추가하기");
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println("list = " + list);

        System.out.println(" ");
        System.out.println("기능 사용하기");
        System.out.println("list.size() = " + list.size());
        System.out.println("list.get(1) = " + list.get(1));
        System.out.println("list.indexOf('C') = " + list.indexOf("C"));
        System.out.println("list.set('Z') = " + list.set(1, "Z"));
        System.out.println("list = " + list);

        System.out.println(" ");
        System.out.println("list 마지막 범위까지 데이터 입력");
        list.add("D");
        list.add("E");
        System.out.println("list = " + list);

        System.out.println(" ");
        System.out.println("list 범위 초과");
        list.add("F");
    }
}
