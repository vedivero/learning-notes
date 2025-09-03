package java.mid2.collection.set.test;

import java.util.Arrays;
import java.util.HashSet;

public class UniqueNamesTest1 {

    public static void main(String[] args) {
        Integer[] inputArr = {30, 20, 20, 10, 10};

        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(inputArr));

        /*Iterator<Integer> iterator = hashSet.iterator();

        while (iterator.hasNext()) {
            hashSet.add(iterator.next());
        }*/

        System.out.println("hashSet = " + hashSet);
    }
}
