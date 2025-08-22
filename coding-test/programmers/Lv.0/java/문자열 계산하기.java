// 문제 설명
// my_string은 "3 + 5"처럼 문자열로 된 수식입니다.
// 문자열 my_string이 매개변수로 주어질 때,
// 수식을 계산한 값을 return 하는 solution 함수를 완성해주세요.

// 입출력 예
// my_string	result
// "3 + 4"	    7

class Solution {
    public int solution(String my_string) {

        String[] str = my_string.trim().split(" ");

        int answer = Integer.parseInt(str[0]);
        for (int i = 1; i < str.length; i += 2) {
            if (str[1].equals("+")) {
                answer += Integer.parseInt(str[2]);
            }else if(str[1].equals("-")){
                answer -= Integer.parseInt(str[2]);
            }
        }
        return answer;
    }
}