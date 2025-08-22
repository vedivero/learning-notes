// 문제 설명
// 정수 n이 매개변수로 주어질 때
// n의 각 자리 숫자의 합을 return하도록 solution 함수를 완성해주세요

// 입출력 예
// n	    result
// 1234	    10
// 930211	16

class Solution {
    public int solution(int n) {
        int answer = 0;

        String number = String.valueOf(n);
        char[] chars = number.toCharArray();

        for (char c : chars) {
            answer += c - '0';
        }

        return answer;
    }
}