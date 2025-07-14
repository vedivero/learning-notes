//문제 설명
//문자열 my_string이 매개변수로 주어집니다.
// my_string안의 모든 자연수들의 합을 return하도록 solution 함수를 완성해주세요.

// 입출력 예
// my_string	        result
// "aAb1B2cC34oOp"	    10
// "1a2b3c4d123"	    16
class Solution {
    public int solution(String my_string) {

        String num = my_string.replaceAll("[a-zA-Z]", "");

        char[] chars = num.toCharArray();

        int sum = 0;
        for (char c : chars) {
            sum += c - '0';
        }
        return sum;
    }
}