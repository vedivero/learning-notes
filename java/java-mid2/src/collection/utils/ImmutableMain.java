package collection.utils;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableMain {

    public static void main(String[] args) {
        //불변 리스트 생성
        List<Integer> list = List.of(1, 2, 3);

        ArrayList<Integer> mutableList = new ArrayList<>(list);
        mutableList.add(4);
        System.out.println(" ");
        System.out.println("mutableList = " + mutableList);
        System.out.println("mutableList.getClass() = " + mutableList.getClass());

        //가변 리스트 -> 불변 리스트로 변경
        List<Integer> unmodifiableList = Collections.unmodifiableList(mutableList);
        System.out.println(" ");
        //unmodifiableList.add(5); // Exception in thread "main" java.lang.UnsupportedOperationException
        System.out.println("unmodifiableList = " + unmodifiableList);
        System.out.println("unmodifiableList.getClass() = " + unmodifiableList.getClass());

    }
}
