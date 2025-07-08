//우주여행을 하던 머쓱이는 엔진 고장으로 PROGRAMMERS-962 행성에 불시착하게 됐습니다.
//입국심사에서 나이를 말해야 하는데, PROGRAMMERS-962 행성에서는 나이를 알파벳으로 말하고 있습니다.
//a는 0, b는 1, c는 2, ..., j는 9입니다. 예를 들어 23살은 cd, 51살은 fb로 표현합니다.
// 나이 age가 매개변수로 주어질 때 PROGRAMMER-962식 나이를 return하도록 solution 함수를 완성해주세요.

//입출력 예
//age	result
//23	"cd"
//51	"fb"
//100	"baa"

class Solution {
    public String solution(int age) {

        String alphabet = "abcdefghij";
        StringBuild sb = new StringBuild();

        for (char c : String.valueOf(age).toCharArray()) {
            int digit = c - '0';
            sb.append(alphabet.charAt(digit));
        }

        return sb.toString();
    }
}
// 나이를 표현하기 위한 숫자는 0~9까지(a,b,c,d,e,f,g,h,i,j)
// 문자를 이어붙이기 위한 StringBuilder 인스턴스 생성
// 매개 변수로 전달되는 age를 String형태로 변환하여 문자 형태 배열로 만들어 반복문을 실행
// char 타입의 숫자 문자는 유니코드로 표현되기 때문에 '0'(코드값 48)을 빼주면,
// 그 차이로 숫자 값을 구할 수 있음( '3'=51 / 51('3')-48('0') = 3 )
// sb 객체에 digit 위치의 문자를 charAt()함수를 사용하여 추가