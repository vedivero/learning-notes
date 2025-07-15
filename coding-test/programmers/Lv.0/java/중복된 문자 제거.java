//문제 설명
//문자열 my_string이 매개변수로 주어집니다.
// my_string에서 중복된 문자를 제거하고
// 하나의 문자만 남긴 문자열을 return하도록 solution 함수를 완성해주세요.

// 입출력 예
// my_string	        result
// "people"	            "peol"
// "We are the world"	"We arthwold"

class Solution {
    public String solution(String my_string) {
        boolean[] seen = new boolean[128];
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);

            if (!seen[ch]) {
                result.append(ch);
                seen[ch] = true;
            }
        }
        return result.toString();
    }
}
// 표준 아스키 범위인 0~127로 불리언 배열을 선언
// 스트링 빌더로 조건에 맞는 문자를 하나씩 추가(append)
// 문자열의 길이만큼 순회하는 반복문안에서
// 0번째 인덱스부터 차례로 순회하며
// seen배열의 해당하는 아스키 코드 값과 동일한 숫자 값의 seen 배열 위치가 false일때만
// result에 해당 문자를 추가하고 값을 true로 변경