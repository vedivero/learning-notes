//외과의사 머쓱이는 응급실에 온 환자의 응급도를 기준으로 진료 순서를 정하려고 합니다.
// 정수 배열 emergency가 매개변수로 주어질 때 응급도가 높은 순서대로 진료 순서를 정한 배열을 return하도록 solution 함수를 완성해주세요.

// 입출력                          예
// emergency	                result
// [3, 76, 24]	                [3, 1, 2]
// [1, 2, 3, 4, 5, 6, 7]	    [7, 6, 5, 4, 3, 2, 1]
// [30, 10, 23, 6, 100]	        [2, 4, 3, 5, 1]

class Solution {
    public int[] solution(int[] emergency) {

        int n = emergency.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int rank=1;
            for (int j = 0; j < n; j++) {
                if (emergency[i] < emergency[j]) {
                    rank++;
                }
            }
            answer[i] = rank;
        }
        return answer;
    }
}
// 매개 변수로 전달되는 배열의 길이를 저장
// 정답을 저장할 정수형 배열을 매개 변수로 전달되는 배열의 길이와 동일하게 선언
// 이중반복문을 사용하여 [i] 인덱스가 나머지 인덱스의 값보다 작으면, 정수형 변수 rank의 값을 1씩 증가시킴
// (우선 순위가 낮을 수록 값이 커져야하기 때문)
// 모든 요소의 값을 비교하여 [i]번째 인덱스의 rank값을 대입