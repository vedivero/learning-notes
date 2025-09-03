package mid2.collection.set.test;

import java.util.HashSet;
import java.util.List;

public class SetOperationsTest {

    public static void main(String[] args) {

        HashSet<Integer> hashSet1 = new HashSet<>(List.of(1, 2, 3, 4, 5));
        HashSet<Integer> hashSet2 = new HashSet<>(List.of(3, 4, 5, 6, 7));

        HashSet<Integer> union = new HashSet<>(hashSet1);
        union.addAll(hashSet2);
        System.out.println(" ");
        System.out.println("합집합 - 전체 수");
        System.out.println("union = " + union);

        HashSet<Integer> intersection = new HashSet<>(hashSet1);
        intersection.retainAll(hashSet2);
        System.out.println(" ");
        System.out.println("교집합 - 공통된 수");
        System.out.println("intersection = " + intersection);

        HashSet<Integer> difference = new HashSet<>(hashSet1);
        difference.removeAll(hashSet2);
        System.out.println(" ");
        System.out.println("차집합 - 나머지 수");
        System.out.println("difference = " + difference);
    }
}
