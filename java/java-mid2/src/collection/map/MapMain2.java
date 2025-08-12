package collection.map;

import java.util.HashMap;

public class MapMain2 {

    public static void main(String[] args) {
        HashMap<String, Integer> studentMap = new HashMap<>();

        System.out.println(" ");
        studentMap.put("A", 90);
        System.out.println("studentMap = " + studentMap);

        System.out.println(" ");
        studentMap.put("A", 100);
        System.out.println("studentMap = " + studentMap);

        System.out.println(" ");
        boolean containsKey = studentMap.containsKey("A");
        System.out.println("containsKey = " + containsKey);

        System.out.println(" ");
        studentMap.remove("A");
        System.out.println("studentMap = " + studentMap);
    }
}
