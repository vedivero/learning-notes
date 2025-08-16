package collection.compare;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SortMain4 {

    public static void main(String[] args) {

        MyUser myUser1 = new MyUser("a", 30);
        MyUser myUser2 = new MyUser("b", 20);
        MyUser myUser3 = new MyUser("c", 10);

        List<MyUser> list = new LinkedList<>();

        list.add(myUser1);
        list.add(myUser2);
        list.add(myUser3);

        System.out.println(" ");
        System.out.println("기본 데이터");
        System.out.println("list = " + list);

        System.out.println(" ");
        System.out.println("Comparable 정렬");
        list.sort(null);
        System.out.println("list = " + list);

        System.out.println(" ");
        System.out.println("IdComparable 정렬");
        list.sort(new IdComparator());
        System.out.println("list = " + list);
    }
}
