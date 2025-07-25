// 문제 설명
// 문자열 my_string이 매개변수로 주어질 때,
// 문자는 소문자로 소문자는 대문자로 변환한 문자열을 return하도록 solution 함수를 완성해주세요.

// 입출력 예
// my_string	result
// "cccCCC" 	"CCCccc"
// "abCdEfghIJ"	"ABcDeFGHij"
class Solution {
    public String solution(String my_string) {

        char[] chars = my_string.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (char c : chars) {
            if (Character.isLowerCase(c)) {
                sb.append(Character.toUpperCase(c));
            } else if (Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        return sb.toString();
    }
}