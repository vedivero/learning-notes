//문제 설명
//약수의 개수가 세 개 이상인 수를 합성수라고 합니다.
// 자연수 n이 매개변수로 주어질 때 n이하의 합성수의 개수를 return하도록 solution 함수를 완성해주세요.

//입출력 예
// n	    result
// 10   	    5
// 15	        8
class Solution {
    public int solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int divCount = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    divCount++;
                }
            }
            if (divCount > 2) {
                count++;
            }
        }
        return count;
    }
}
// n이하의 각 정수 마다 가지는 약수의 개수가 3개 이상인 합성 수를 구하는 문제
// 첫 번째 반복문에서 n이하의 모든 수를 순회하고
// 내부 반복문에서 약수의 개수를 구하는데
// 조건식을 1부터 i의 크기로 제한하고
// i를 범위 내의 모든수로 나누어서, 나머지가 0인 것은 그 수의 약수가 되기 때문에
// 그 개수를 카운트하기
// 내부 반복문을 다 순회하고 나서 count가 3이상인 것을 카운트하여 정답을 유추