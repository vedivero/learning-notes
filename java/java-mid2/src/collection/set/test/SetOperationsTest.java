package collection.set.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetOperationsTest {

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(List.of(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(List.of(3, 4, 5, 6, 7));

        Set<Integer> union = new HashSet<>();
        union.addAll(set1);
        union.addAll(set2);
        System.out.println("union = " + union);

        HashSet<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("intersection = " + intersection);

        HashSet<Integer> difference = new HashSet<>(set1);
        difference.retainAll(set2);
        System.out.println("difference = " + difference);
    }
}
