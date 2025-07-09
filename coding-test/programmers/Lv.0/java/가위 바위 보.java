//문제 설명
//가위는 2 바위는 0 보는 5로 표현합니다.
// 가위 바위 보를 내는 순서대로 나타낸 문자열 rsp가 매개변수로 주어질 때,
// rsp에 저장된 가위 바위 보를 모두 이기는 경우를 순서대로 나타낸 문자열을 return하도록 solution 함수를 완성해보세요.

//입출력 예
//rsp	result
//"2"	"0"
//"205"	"052"

class Solution {
    public String solution(String rsp) {

        char[] char_array = rsp.toCharArray();

        StringBuilder sb = new StringBuilder();

        for (char c : char_array) {
            if (c == '0') {
                sb.append('5');
            } else if (c == '2') {
                sb.append('0');
            } else if (c == '5') {
                sb.append('2');
            }
        }
        return sb.toString();
    }
}
// 문자열 숫자를 문자 배열로 변환
// 가변 문자열 인스턴스를 생성
// 문자 배열의 요소들을 순회
// 각 숫자에 대응하는 가위바위보 숫자를 StringBuilder에 추가
// 마지막으로 toString()으로 불변 문자열로 변환