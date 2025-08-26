package collection.array;

public class MyArrayListV4Main {

    public static void main(String[] args) {

        MyArrayListV4 stringList = new MyArrayListV4<>();
        System.out.println(" ");
        System.out.println("데이터 추가하기");
        stringList.add("A");
        stringList.add("B");
        stringList.add("C");
        System.out.println("stringList = " + stringList);


        MyArrayListV4<Integer> integerList = new MyArrayListV4<>();
        System.out.println(" ");
        System.out.println("데이터 추가하기");
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        System.out.println("integerList = " + integerList);

    }
}
