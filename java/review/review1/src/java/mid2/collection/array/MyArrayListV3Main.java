package java.mid2.collection.array;

public class MyArrayListV3Main {

    public static void main(String[] args) {

        MyArrayListV3 list = new MyArrayListV3();
        System.out.println(" ");
        System.out.println("데이터 추가하기");
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println("list = " + list);

        // 특정 위치 추가
        System.out.println(" ");
        System.out.println(" 특정 위치 추가");
        list.add(2, "D");
        System.out.println("list = " + list);

        // 첫 번째 위치 추가
        System.out.println(" ");
        System.out.println("첫 번째 위치 추가");
        list.add(0, "Z");
        System.out.println("list = " + list);

        // 마지막 위치 추가
        System.out.println(" ");
        System.out.println("마지막 위치 추가");
        list.add(5, "F");
        System.out.println("list = " + list);

        // 삭제
        System.out.println(" ");
        System.out.println("요소 삭제");
        Object remove = list.remove(3);
        System.out.println("remove = " + remove);
        System.out.println("list = " + list);

    }
}
