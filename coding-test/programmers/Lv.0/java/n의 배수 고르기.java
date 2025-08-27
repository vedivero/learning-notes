// 문제 설명
// 정수 n과 정수 배열 numlist가 매개변수로 주어질 때,
// numlist에서 n의 배수가 아닌 수들을 제거한 배열을 return하도록 solution 함수를 완성해주세요.

// 입출력 예
//  n	    numlist	                            result
//  3	    [4, 5, 6, 7, 8, 9, 10, 11, 12]	    [6, 9, 12]
//  5	    [1, 9, 3, 10, 13, 5]	            [10, 5]
//  12	    [2, 100, 120, 600, 12, 12]	        [120, 600, 12, 12]

import java.util.*;
class Solution {
    public int[] solution(int n, int[] numlist) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int num : numlist) {
            if (num % n == 0) {
                list.add(num);
            }
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
// ArrayList를 사용해서 numList의 각 요소가 n으로 정확히 나누어 떨어지는 경우에만 ArrayList에 추가
// 배열 형태로 답을 반환해야하기 때문에
// ArrayList에 담긴 결과의 길이를 사용해서 정답으로 제출할 배열을 선언
// ArrayList의 각 요소를 배열의 요소에 값을 대입