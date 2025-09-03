package java.mid2.collection.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionSortMain {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Integer max = Collections.max(list);
        Integer min = Collections.min(list);

        System.out.println("min = " + min);
        System.out.println("max = " + max);

        System.out.println(" ");
        System.out.println("list = " + list);

        System.out.println(" ");
        Collections.shuffle(list);
        System.out.println("Shuffle list = " + list);

        System.out.println(" ");
        Collections.sort(list);
        System.out.println("sort list = " + list);

        System.out.println(" ");
        Collections.reverse(list);
        System.out.println("reverse list = " + list);


    }
}
