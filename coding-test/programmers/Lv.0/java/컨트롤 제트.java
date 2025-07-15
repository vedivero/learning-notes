// 문제 설명
// 숫자와 "Z"가 공백으로 구분되어 담긴 문자열이 주어집니다.
// 문자열에 있는 숫자를 차례대로 더하려고 합니다.
// 이 때 "Z"가 나오면 바로 전에 더했던 숫자를 뺀다는 뜻입니다.
// 숫자와 "Z"로 이루어진 문자열 s가 주어질 때,
// 머쓱이가 구한 값을 return 하도록 solution 함수를 완성해보세요.

// 입출력 예
// s	            result
// "1 2 Z 3"	    4
// "10 20 30 40"	100
// "10 Z 20 Z 1"	1
// "10 Z 20 Z"  	0
// "-1 -2 -3 Z"	    -3
class Solution {
    public int solution(String s) {
        String[] tokens = s.split(" ");
        int sum = 0;
        int prev = 0;

        for (String token : tokens) {
            if (token.equals("Z")) {
                sum -= prev;
            } else {
                prev = Integer.parseInt(token);
                sum += prev;
            }
        }
    }
}
// 문제에 문자열이 공백으로 구분되어 있다고 했으니,
// 공백을 기준으로 문자열을 나누어서 문자열 배열에 대입
// 문제에 대한 답변이 될 정수형 변수 sum 선언하고 값을 0으로 초기화
// 이전 값을 저장할 정수형 변수 prev 선언하고 값을 0으로 초기화
// 공백을 기준으로 나눈 문자열 배열 tokens를 순회하며
// 해당 값이 "Z"인 경우에는 총 합에서 이전 값을 빼기
// 해당 값이 "Z"인 아닌 경우에는,
// 문자열 숫자를 정수형으로 형변환하여 이전 값 prev에 저장하고
// sum에 숫자를 더한다.