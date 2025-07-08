//문자열 my_string이 매개변수로 주어집니다.
//my_string을 거꾸로 뒤집은 문자열을 return하도록 solution 함수를 완성해주세요.
class Solution {
    public String solution(String my_string) {

        char[] char_array = my_string.toCharArray();
        int size = my_string.length();
        char[] reverse_array = new char[size];

        for (int i = 0; i < size; i++) {
            reverse_array[i] = char_array[size - 1 - i];
        }

        return new String(reverse_array);
    }
}
// 문자열의 각 문자를 거꾸로 출력하는 문제
// toCharArray()함수를 사용해서 문자열을 char 타입의 배열에 할당
// 앞 뒤 순서가 반전된 배열을 담을 새로운 변수를 선언
// 반복문을 통해 순서대로 되어 있는 배열의 각 요소의 마지막 인덱스부터
// 새로운 배열의 첫 번째 인덱스에 차례로 할당
// 순서가 반전된 배열을 String 객체를 사용하여 문자열 생성

