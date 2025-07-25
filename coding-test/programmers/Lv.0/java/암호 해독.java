// 문제 설명
// 군 전략가 머쓱이는 전쟁 중 적군이 다음과 같은 암호 체계를 사용한다는 것을 알아냈습니다.
// 암호화된 문자열 cipher를 주고받습니다.
// 그 문자열에서 code의 배수 번째 글자만 진짜 암호입니다.
// 문자열 cipher와 정수 code가 매개변수로 주어질 때 해독된 암호 문자열을 return하도록 solution 함수를 완성해주세요.

// 입출력 예
// cipher                   	code	result
// "dfjardstddetckdaccccdegk"  	4   	"attack"
// "pfqallllabwaoclk"	        2	    "fallback"

class Solution {
    public String solution(String cipher, int code) {
        StringBuilder sb = new StringBuilder();

        char[] char_arr = cipher.toCharArray();
        for (int i = code-1; i <char_arr.length; i += code) {
            sb.append(char_arr[i]);
        }

        return sb.toString();
    }
}

// 반복문의 초기 값을 code-1로 설정(배열의 인덱스는 0부터 시작하기 때문)