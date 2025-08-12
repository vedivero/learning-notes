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
// 문자열의 각 문자의 위치를 바꾸기 위해 캐릭터 형태의 배열에 문자열을 담음
// 임시 변수를 생성해서 num1에 해당하는 문자를 담고
// num2에 해당하는 문자를 num1에 담고
// 다시 temp에 임시로 보관했던 문자를 num2에 담아서 결과를 도출

class Solution {
    public String solution(String my_string, int num1, int num2) {

        char[] chars = my_string.toCharArray();

        chars[num1] = my_string.charAt(num2);
        chars[num2] = my_string.charAt(num1);

        return String.valueOf(chars);

    }
}
// 이 풀이는 chars[num1]과 chars[num2]는 다른 참조값을 가지고 있기 때문에
// 바로 값을 대입해도 되므로 임시로 숫자를 저장할 변수를 사용하지 않아도 된다.