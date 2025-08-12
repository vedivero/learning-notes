package collection.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapMain1 {

    public static void main(String[] args) {
        HashMap<String, Integer> studentMap = new HashMap<>();

        System.out.println(" ");
        studentMap.put("studentA", 90);
        studentMap.put("studentB", 80);
        studentMap.put("studentC", 80);
        studentMap.put("studentD", 70);
        studentMap.put("studentF", 60);

        System.out.println(" ");
        System.out.println("studentMap = " + studentMap);

        Integer result = studentMap.get("studentD");
        System.out.println("result = " + result);

        System.out.println(" ");
        Set<String> ketSet = studentMap.keySet();
        for (String key : ketSet) {
            Integer value = studentMap.get(key);
            //System.out.println("value = " + value + ", key = " + key);
            System.out.println("key = " + key);
        }

        System.out.println(" ");
        Set<Map.Entry<String, Integer>> entries = studentMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("value = " + value + ", key = " + key);
        }

        System.out.println(" ");
        Collection<Integer> values = studentMap.values();
        for (Integer value : values) {
            System.out.println("value = " + value);
        }

    }
}
