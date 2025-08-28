// 문제 설명
// 어떤 자연수를 제곱했을 때 나오는 정수를 제곱수라고 합니다.
// 정수 n이 매개변수로 주어질 때,
// n이 제곱수라면 1을 아니라면 2를 return하도록 solution 함수를 완성해주세요.

// 입출력 예
//  n	    result
//  144	    1
//  976	    2

class Solution {
    public int solution(int n) {
        double num = Math.sqrt(n);
        return (int) n % num == 0 ? 1 : 2;
    }
}
// 제곱수를 구하는 문제
// 매개 변수로 전달되는 숫자의 제곱근을 Math.sqrt()로 구하고
// 제곱근으로 매개 변수를 나머지 연산을 했을 때, 결과가 0이면 제곱 수가 됨

class Solution {
    public int solution(int n) {
        return n % Math.sqrt(n) == 0 ? 1 : 2;
    }
}
// 더 간결한 풀이 방법