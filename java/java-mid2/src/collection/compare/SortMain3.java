package collection.compare;

import java.util.Arrays;
import java.util.Comparator;

public class SortMain3 {

    public static void main(String[] args) {

        MyUser myUser1 = new MyUser("a", 30);
        MyUser myUser2 = new MyUser("b", 20);
        MyUser myUser3 = new MyUser("c", 10);

        MyUser[] array = {myUser1, myUser2, myUser3};
        System.out.println(" ");
        System.out.println("기본 데이터");
        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));

        System.out.println(" ");
        System.out.println("Comparable 기본 정렬");
        Arrays.sort(array);
        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));

        System.out.println(" ");
        System.out.println("문자열 정렬 - IdComparator");
        Arrays.sort(array,new IdComparator());
        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));

        System.out.println(" ");
        System.out.println("문자열 정렬 - IdComparator.reverser()");
        Arrays.sort(array,new IdComparator().reversed());
        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));

    }
}
