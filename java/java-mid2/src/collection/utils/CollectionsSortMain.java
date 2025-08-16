package collection.utils;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsSortMain {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Integer max = Collections.max(list);
        Integer min = Collections.min(list);

        System.out.println(" ");
        System.out.println("max = " + max);
        System.out.println(" ");
        System.out.println("min = " + min);

        System.out.println(" ");
        System.out.println("list = " + list);

        System.out.println(" ");
        System.out.println("Shuffle");
        Collections.shuffle(list);
        System.out.println("list = " + list);
        Collections.shuffle(list);
        System.out.println("list = " + list);

        System.out.println(" ");
        System.out.println("Sort() 정렬");
        Collections.sort(list);
        System.out.println("list = " + list);

        System.out.println(" ");
        System.out.println("reverse() 정렬");
        Collections.reverse(list);
        System.out.println("list = " + list);
    }
}
