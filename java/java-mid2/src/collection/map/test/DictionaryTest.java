package collection.map.test;

import java.util.HashMap;
import java.util.Scanner;

public class DictionaryTest {

    public static void main(String[] args) {

        HashMap<String, String> dictionaryMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("==단어 입력 단계==");
        while (true) {

            System.out.println("영어 단어를 입력하세요. (종료는 'q' 입력)");
            String engKeyword = scanner.nextLine();
            String quit = "q";
            if (engKeyword.equals(quit)) {
                break;
            }
            System.out.println("한글 뜻을 입력하세요.");
            String korKeyword = scanner.nextLine();
            dictionaryMap.put(engKeyword, korKeyword);
        }

        System.out.println(" ");
        System.out.println("==단어 검색 단계==");
        while (true) {

            System.out.println("찾을 영단어를 입력하세요. (종료는 'q' 입력)");
            String searchKeyword = scanner.nextLine();
            String quit = "q";
            if (searchKeyword.equals(quit)) {
                break;
            }

            boolean containsKey = dictionaryMap.containsKey(searchKeyword);

            if (containsKey) {
                System.out.println("dictionaryMap = " + dictionaryMap.get(searchKeyword));
            }else {
                System.out.println("No exist in dictionaryMap");
            }
        }
    }
}
