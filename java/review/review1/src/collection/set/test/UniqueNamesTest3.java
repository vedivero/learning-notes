package collection.set.test;

import java.util.Arrays;
import java.util.TreeSet;

public class UniqueNamesTest3 {

    public static void main(String[] args) {

        Integer[] inputArr = {30, 20, 20, 10, 10};

        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(inputArr));
        System.out.println("treeSet = " + treeSet);

    }
}
