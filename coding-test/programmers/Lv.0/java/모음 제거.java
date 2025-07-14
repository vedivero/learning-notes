//문제 설명
//영어에선 a, e, i, o, u 다섯 가지 알파벳을 모음으로 분류합니다.
// 문자열 my_string이 매개변수로 주어질 때
// 모음을 제거한 문자열을 return하도록 solution 함수를 완성해주세요.

// 입출력 예
// my_string	        result
// "bus"	            "bs"
// "nice to meet you"	"nc t mt y"
class Solution {
    public String solution(String my_string) {

        StringBuilder answer = new StringBuilder();
        char[] moum = {'a', 'e', 'i', 'o', 'u'};

        for (int i = 0; i <my_string.length(); i++) {

            char c = my_string.charAt(i);
            boolean isMoum = false;

            for (char m : moum) {
                if (c == m) {
                    isMoum = true;
                    break;
                }
            }

            if (!isMoum) {
                answer.append(c);
            }
        }
        return answer.toString();
    }
}
//반복문을 순회하며, 문자열을 이어 붙이기 좋은 가변 문자열 객체 StringBuilder를 사용
//모음에 해당하는 문자 5개를 char 타입의 배열에 초기화
//매개변수로 전달받은 문자열의 길이만큼 배열을 순회
//my_string문자열을 charAt() 함수를 사용하여 문자열의 모든 단어 탐색
//boolean변수로 모음 여부를 판단 값 저장
//my_string문자열을 순회하는 내부 반복문(모음)에서
//my_string의 i번째 문자와 비교하여 true/false를 판별
//moum이 아니다. 즉, isMoum=false면,
//StringBuilder에 해당 문자를 append