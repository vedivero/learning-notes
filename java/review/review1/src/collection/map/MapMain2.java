package collection.map;

import java.util.HashMap;

public class MapMain2 {

    public static void main(String[] args) {
        HashMap<String, Integer> studentMap = new HashMap<>();

        studentMap.put("studentA", 90);
        System.out.println("studentMap = " + studentMap);

        System.out.println("같은 키 입력하면 기존 키와 값을 교채");
        studentMap.put("studentA", 100);
        System.out.println("studentMap = " + studentMap);

        System.out.println(" ");
        boolean containsKey = studentMap.containsKey("studentA");
        System.out.println("containsKey = " + containsKey);

        studentMap.remove("studentA");
        System.out.println("studentMap = " + studentMap);
    }
}
