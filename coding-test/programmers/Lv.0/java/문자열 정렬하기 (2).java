import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";

        // 매개 변수로 전달된 문자열을 소문자로 변환
        answer = my_string.toLowerCase();
        
        // 소문자로 변환된 문자열을 문자 배열에 대입
        char[] charArr = answer.toCharArray();
        
        // 문자 배열을 sort 함수를 사용하여 정렬
        Arrays.sort(charArr);
        
        // 오름차순으로 정렬된 문자 배열을 문자열에 대입
        String result = new String(charArr);
        
        return result;
    }
}