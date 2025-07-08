//문자열 my_string과 정수 n이 매개변수로 주어질 때,
//my_string에 들어있는 각 문자를 n만큼 반복한 문자열을 return 하도록 solution 함수를 완성해보세요.
//입출력 예
//my_string	    n	result
//"hello"	    3	"hhheeellllllooo"
class Solution {
    public String solution(String my_string, int n) {

        int string_length = my_string.length();
        char[] char_array = my_string.toCharArray();
        String[] new_string = new String[string_length];

        for (int i = 0; i < string_length; i++) {
            new_string[i] = String.valueOf(char_array[i]).repeat(n);
        }

        return String.join("", new_string);
    }
}

// 문자열의 길이를 먼저 구함
// 매개 변수로 받은 문자열의 각 문자를 분리하기 위해 toCharArray()함수를 사용하여 char 타입의 배열에 담음
// 문자열 형태의 배열을 선언하고 문자열의 길이로 문자열 배열의 초기 길이를 설정
// 반복문을 통해 문자열 형태의 배열에다가 char_array 배열에 담긴 각 요소의 타입을 String 형태로 변환하고
// repeat함수를 통해 n번 반복하여 담는다.
// 그렇게 담긴 배열의 값을 String 객체의 join  메서드를 사용하여 이어 붙인다.

// 다른 풀이 방법
class Solution {
    public String solution(String my_string, int n) {

        char[] char_array =  my_string.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < my_string.length(); i++) {
            sb.append(String.valueOf(char_array[i]).repeat(n));
        }
        return new String(sb);
    }
}
// 매개 변수로 전달되는 문자열을 바로 char 형태의 배열 변수에 저장
// 가변 문자열 객체인 StringBuilder를 사용하여 처리
// 반복문을 통해 문자열의 길이만큼 반복
// StringBuilder으로 생성된 sb 변수에 캐릭터 배열의 i 번째 인덱스를 n번 만큼 반복하여 추가
// 가변 문자열 객체를 불변 객체로 생성하여 마무리


// 다른 풀이 방법
class Solution {
    public String solution(String my_string, int n) {

        char[] char_array =  my_string.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : char_array) {
            sb.append(String.valueOf(c).repeat(n));
        }
        return new String(sb);
    }
}
// 위 방법과 동일하나, 향상된 반복문을 사용하여 좀 더 간결하고 직관적으로 처리
