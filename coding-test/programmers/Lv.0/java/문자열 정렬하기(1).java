//문제 설명
//문자열 my_string이 매개변수로 주어질 때,
// my_string 안에 있는 숫자만 골라 오름차순 정렬한 리스트를 return 하도록 solution 함수를 작성해보세요.

// 입출력 예
// my_string	result
// "hi12392"	[1, 2, 2, 3, 9]
// "p2o4i8gj2"	[2, 2, 4, 8]
// "abcde0"	    [0]

import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        StringBuilder digits = new StringBuilder();

        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            if (Character.isDigit(c)) {
                digits.append(c);
            }
        }

        char[] chars = digits.toString().toCharArray();
        int[] answer = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            answer[i] = chars[i] - '0';
        }

        Arrays.sort(answer);

        return answer;
    }
}

//가변 문자열 객체인 StringBuilder를 생성
//문자열의 길이 만큼 반복문을 실행
//문자열의 각 요소가 '문자형 숫자'인지를 판단하여 가변 문자열 객체에 추가
//문자형 숫자가 담긴 digits 변수를 문자열로 형변환 후, 문자 타입 배열에 대입
//문자 타입 배열을 순회하며, 각 인덱스의 값에 문자열 숫자 '0'을 빼기
//유니코드('0'=48) 값을 이용하여 정수형 숫자를 유추
//유틸리티 함수를 이용하여 오름차순으로 정렬