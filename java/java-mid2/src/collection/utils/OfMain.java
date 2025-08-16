package collection.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class OfMain {

    public static void main(String[] args) {

        // XXX.of = 값을 못 바꾸는 불변 컬렉션 생성
        List<Integer> list = List.of(1, 2, 3);
        System.out.println(" ");
        System.out.println("list = " + list);

        System.out.println(" ");
        //class java.util.ImmutableCollections$ListN
        System.out.println("list.getClass() = " + list.getClass());


        Set<Integer> set = Set.of(1, 2, 3);
        System.out.println(" ");
        System.out.println("set = " + set);

        System.out.println(" ");
        //class java.util.ImmutableCollections$SetN
        System.out.println("set.getClass() = " + set.getClass());

        Map<Integer, String> map = Map.of(1, "one", 2, "two");
        System.out.println(" ");
        System.out.println("map = " + map);

        System.out.println(" ");
        //class java.util.ImmutableCollections$MapN
        System.out.println("map.getClass() = " + map.getClass());


    }
}
