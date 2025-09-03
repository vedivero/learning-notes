package mid2.collection.map.test;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemPriceTest {

    public static void main(String[] args) {

        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("사과", 500);
        hashMap.put("바나나", 500);
        hashMap.put("망고", 1000);
        hashMap.put("딸기", 1000);

        ArrayList<String> resultList = new ArrayList<>();

        for (String string : hashMap.keySet()) {
            Integer price = hashMap.get(string);
            if (price == 1000) {
                resultList.add(string);
            }
        }

        System.out.println("resultList = " + resultList);
    }
}
