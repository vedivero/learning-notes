package collection.iterable;

import java.util.*;

public class JavaIterableMain {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);


        System.out.println(" ");

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        printAll(list.iterator());
        forEach(list);

        System.out.println(" ");

        printAll(set.iterator());
        forEach(set);
    }

    /*private static void forEach(Set<Integer> set) {
        for (Integer i : set) {
            System.out.println(i);
        }
    }*/

    /*private static void forEach(List<Integer> list) {
        for (Integer i : list) {
            System.out.println(i);
        }
    }*/

    private static void forEach(Iterable<Integer> iterable) {
        System.out.println("iterable.getClass() = " + iterable.getClass());
        for (Integer i : iterable) {
            System.out.println(i);
        }
    }

    private static void printAll(Iterator<Integer> iterator) {
        while (iterator.hasNext()) {
            System.out.println("iterator.next() = " + iterator.next());
        }
    }
}
