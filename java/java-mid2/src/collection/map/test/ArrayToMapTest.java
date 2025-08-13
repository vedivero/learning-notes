package collection.map.test;

import java.util.HashMap;

public class ArrayToMapTest {

    public static void main(String[] args) {

        String[][] productArr = {{"Java", "10000"}, {"Spring", "20000"}, {"JPA", "30000"}};

        HashMap<String, Integer> productMap = new HashMap<>();
        for (String[] product : productArr) {
            String key = product[0];
            String value = product[1];

            productMap.put(key, Integer.valueOf(value));
        }

        for (String key : productMap.keySet()) {
            System.out.println(" ");
            System.out.println("key = " + key);
            System.out.println("productMap = " + productMap.get(key));
        }
    }
}
