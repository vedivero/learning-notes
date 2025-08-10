package collection.set.test;

import java.util.*;

public class UniqueNamesTest2 {

    public static void main(String[] args) {

        Integer[] inputArr = {30, 20, 20, 10, 10};

        //List<Object> list = List.of(inputArr);
        //List<Integer> list = Arrays.asList(inputArr);

        Set<Object> set = new LinkedHashSet<>(List.of(inputArr));

        /*for (Integer i : inputArr) {
            set.add(i);
        }*/

        for (Object o : set) {
            System.out.println("o = " + o);
        }
    }
}
