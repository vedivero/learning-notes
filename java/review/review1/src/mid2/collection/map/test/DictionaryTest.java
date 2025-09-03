package mid2.collection.map.test;

import java.util.HashMap;
import java.util.Scanner;

public class DictionaryTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1. 영어 단어 입력하기 : ");
        System.out.println("종료는 : q");

        HashMap<String, String> dictionaryMap = new HashMap<>();

        while (true) {

            System.out.println("영어 단어를 입력하세요. : ");
            String eng_word = sc.nextLine();
            if (eng_word.equals("q")) {
                break;
            }
            System.out.println("2. 한글 뜻을 입력하세요.");
            String kor_word = sc.nextLine();
            dictionaryMap.put(eng_word, kor_word);
        }

        System.out.println("3. 검색할 영어 단어를 입력하세요. : ");
        System.out.println("종료는 : q");
        while (true) {
            String search_word = sc.nextLine();
            if (search_word.equals("q")) {
                break;
            }

            String result = dictionaryMap.get(search_word);

            if (result == null) {
                System.out.println(search_word + "은(는) 사전에 없는 단어입니다.");
            } else {
                System.out.println(search_word + "의 뜻은 " + result + "입니다.");
            }
        }
    }
}
