//i팩토리얼 (i!)은 1부터 i까지 정수의 곱을 의미합니다.
// 예를들어 5! = 5 * 4 * 3 * 2 * 1 = 120 입니다.
// 정수 n이 주어질 때 다음 조건을 만족하는 가장 큰 정수 i를 return 하도록 solution 함수를 완성해주세요.
class Solution {
    public int solution(int n) {

        int factoral = 1;
        int i = 1;

        while (true) {
            factoral *= i;
            if (factoral > n) return i - 1;
            i++;
        }
    }
}
// 팩토리얼의 결과가 n보다 작은 최대 팩토리얼을 구하는 문제
// 팩토리얼 저장할 변수 factorial, i를 선언
// i의 값을 1씩 증가시키면서 factorial이 n보다 클 때,
// 해당 i값의 이전 i값이 n이하의 최대 팩토리얼
