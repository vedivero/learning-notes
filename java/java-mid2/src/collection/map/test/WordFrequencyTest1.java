package collection.map.test;

import java.util.HashMap;

public class WordFrequencyTest1 {

    public static void main(String[] args) {
        String text = "orange banana apple apple banana apple";

        HashMap<String, Integer> hashMap = new HashMap<>();
        String[] words = text.split(" ");

        for (String word : words) {
            Integer count = hashMap.get(word);
            if (count == null) {
                count = 0;
            }
            count++;
            hashMap.put(word, count);
        }
        System.out.println("hashMap = " + hashMap);
    }
}
