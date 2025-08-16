package collection.utils;

import collection.list.ArrayList;
import collection.list.LinkedList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EmptyListMain {

    public static void main(String[] args) {

        //비어있는 가변 리스트
        ArrayList<Integer> list1 = new ArrayList<>();
        LinkedList<Integer> list2 = new LinkedList<>();

        //비어있는 불변 리스트
        List<Integer> list3 = Collections.emptyList(); // Java 1.5
        List<Integer> list4 = List.of(); // Java 9

        System.out.println("list3 = " + list3);
        System.out.println("list3.getClass() = " + list3.getClass());

        System.out.println(" ");
        System.out.println("list4 = " + list4);
        System.out.println("list4.getClass() = " + list4.getClass());

        System.out.println(" ");
        Integer[] arr = {1, 2, 3, 4, 5};
        List<Integer> asList = Arrays.asList(arr);
        List<Integer> listOf = List.of(arr);

        asList.set(0, 100);

        System.out.println("asList = " + asList);
        System.out.println("listOf = " + listOf);
    }
}
