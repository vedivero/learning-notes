//문자열 my_string과 문자 letter이 매개변수로 주어집니다.
// my_string에서 letter를 제거한 문자열을 return하도록 solution 함수를 완성해주세요.
//입출력 예
//my_string	    letter	result
//"abcdef"	    "f"	    "abcde"
//"BCBdbe"	    "B"	    "Cdbe"
class Solution {
    public String solution(String my_string, String letter) {
        return my_string.replace(letter, "");
    }
}
// replace 함수를 사용하여 문자열의 특정 문자(letter)를 ""(빈 문자)로 치환

// 다른 풀이 방법
class Solution {
    public String solution(String my_string, String letter) {

        //my_string = abcdef
        //letter = c
        StringBuilder sb = new StringBuilder();
        int index = my_string.indexOf(letter); // 2

        while (index == -1) {
            sb.append(my_string, 0, index); // ab
            my_string = my_string.substring(index + 1); // def
            index = my_string.indexOf(letter); // -1
        }
        sb.append(my_string);
        return sb.toString();
    }
}
// StringBuilder 인스턴스를 생성
// 제거하고 싶은 문자의 위치를 저장
// 반복문안에서 my_string이라는 문자열을 가지고 0번째부터 index번째까지 잘라서 StringBuilder에 추가(=substring)
// 제거한 문자(letter)의 위치 다음 index부터 끝까지의 문자열을 my_string 재 정의
// 재 정의된 my_string문자열에 제거 문자(letter)가 있는지 확인
// indexOf 메서드는 찾는 문자가 없을 경우 -1을 반환
// 반복문을 빠져나와서 특정 문자가 제거된 my_string을 StringBuilder에 추가
// 가변 상태의 sb변수를 불변 객체로 변환하여 임의의 사용자에 의해 변경되지 않도록 수정