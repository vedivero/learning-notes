package collection.map.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ArrayToMapTest {

    public static void main(String[] args) {
        String[][] productArr = {{"Java", "10000"}, {"Spring", "20000"}, {"JPA", "30000"}};

        HashMap<String, String> hashMap = new HashMap<>();
        for (String[] strings : productArr) {
            hashMap.put(strings[0],strings[1]);
        }

        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println("제품 : " + entry.getKey() + ", 가격 : " + entry.getValue());
        }
    }
}
