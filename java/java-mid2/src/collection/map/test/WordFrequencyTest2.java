package collection.map.test;

import java.util.HashMap;

public class WordFrequencyTest2 {

    public static void main(String[] args) {
        String text = "orange banana apple apple banana apple";

        HashMap<String, Integer> hashMap = new HashMap<>();
        String[] words = text.split(" ");

        for (String word : words) {
            hashMap.put(word, hashMap.getOrDefault(word, 0) +1);
        }

        System.out.println("hashMap = " + hashMap);
    }
}
