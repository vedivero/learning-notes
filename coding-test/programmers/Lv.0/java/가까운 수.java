// 문제 설명
// 정수 배열 array와 정수 n이 매개변수로 주어질 때,
// array에 들어있는 정수 중 n과 가장 가까운 수를 return 하도록 solution 함수를 완성해주세요.

// 입출력 예
// array	        n	    result
// [3, 10, 28]	    20	    28
// [10, 11, 12]	    13	    12

import java.util.Arrays;

class Solution {
    public int solution(int[] array, int n) {
        Arrays.sort(array);

        int answer = array[0];

        for (int i = 1; i < array.length; i++) {
            int diff = Math.abs(array[i] - n);

            if (diff < minDiff) {
                minDiff = diff;
                answer = array[i];
            }
        }

        return answer;
    }
}
