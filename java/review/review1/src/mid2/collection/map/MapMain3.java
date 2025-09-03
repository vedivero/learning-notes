package mid2.collection.map;

import java.util.HashMap;

public class MapMain3 {

    public static void main(String[] args) {

        HashMap<String, Integer> studentMap = new HashMap<>();

        studentMap.put("studentA", 50);
        System.out.println("studentMap = " + studentMap);

        System.out.println(" ");
        if (!studentMap.containsKey("studentA")) {
            studentMap.put("studentA", 100);
        }
        System.out.println("studentMap = " + studentMap);

        System.out.println(" ");
        studentMap.putIfAbsent("studentA", 90);
        studentMap.putIfAbsent("studentB", 90);
        System.out.println("studentMap = " + studentMap);
    }
}
