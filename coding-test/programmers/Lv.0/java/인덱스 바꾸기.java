// 문제 설명
// 문자열 my_string과 정수 num1, num2가 매개변수로 주어질 때,
// my_string에서 인덱스 num1과 인덱스 num2에 해당하는 문자를 바꾼 문자열을 return 하도록 solution 함수를 완성해보세요.

// 입출력 예
// my_string	num1	num2	result
// "hello"	    1	    2   	"hlelo"
// "I love you"	3	    6	    "I l veoyou"

class Solution {
    public String solution(String my_string, int num1, int num2) {
        char[] chars = my_string.toCharArray();

        char temp;
        temp = chars[num1];
        chars[num1] = chars[num2];
        chars[num2] = temp;

        return new String(chars);
    }
}