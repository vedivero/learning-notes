package mid2.collection.map.test;

import java.util.HashMap;

public class WordFrequenctTest1 {

    public static void main(String[] args) {
        String text = "orange banana apple apple banana apple";

        String[] str = text.split(" ");

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String string : str) {
            hashMap.put(string, hashMap.getOrDefault(string, 0) + 1);
        }

        System.out.println("hashMap = " + hashMap);
    }
}
