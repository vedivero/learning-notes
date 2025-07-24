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

        int minDiff = Integer.MAX_VALUE;
        int answer = 0;

        for (int i = 0; i < array.length; i++) {
            int diff = Math.abs(array[i] - n);

            if (diff < minDiff) {
                minDiff = diff;
                answer = array[i];
            }
        }

        return answer;
    }
}

// 매개 변수 n이 array 배열의 원소 중, 가장 차이가 적은 것을 찾는 문제
// 우선 배열을 오름차순으로 정렬

// Integer클래스의 MAX_VALUE는 2,147,483,647.
// 어떤 값이 입력되어도 int형태로 전달되는 매개변수 n에 대한 처리가 가능
// minDiff 변수에 int 형태의 최대값을 할당
// 정답을 담을 변수 answer 선언 및 0으로 초기화

// 오름차순으로 정렬된 배열을 순회하며
// 각 요소에서 n을 뺸 값을 절대 값으로
// 반복문 내에서 diff 변수에 임시 저장

// diff(절대 값)이 minDiff(현재 최대 값)보다 작으면
// diff(절대 값)를 minDiff 변수에 대입하고
// 정답에 해당 i번째 index의 값을 정답 변수에 대입

// 이 반복문을 전체 요소를 순회하며 반복하면 절대 값이 가장 작은 수가
// answer 변수에 담아진다.