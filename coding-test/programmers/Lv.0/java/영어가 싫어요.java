// 문제 설명
// 영어가 싫은 머쓱이는 영어로 표기되어있는 숫자를 수로 바꾸려고 합니다.
// 문자열 numbers가 매개변수로 주어질 때,
// numbers를 정수로 바꿔 return 하도록 solution 함수를 완성해 주세요.

// 입출력 예
// numbers	result
// "onetwothreefourfivesixseveneightnine"	123456789
// "onefourzerosixseven"	14067

class Solution {
    public long solution(String numbers) {
        long answer = 0;

        String[] words = new String[]{
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine"
        };

        for (int i = 0; i < ; i++) {
            numbers = numbers.replace(words[i], String.valueOf(i));
        }

        return Long.parseLong(numbers);
    }
}

// 숫자에 해당되는 단어를 숫자로 바꾸는 문제
// 숫자를 판단하기 위해 0~9까지의 숫자를 영문 표기로 배열에 선언
// words 배열의 각 요소를 순회하며 매개 변수로 전달받은 문자열에서 찾아서 치환
// 첫 번째 인자로 해당되는 키워드를 찾고 두 번째 인자로 치환할 문자를 선언
// 알파벳에 해당되는 숫자는 반복문안에서 0부터 시작되어 순차적으로 순회하기 때문에
// n번째의 해당하는 영문 표기가 리턴
// 해당 숫자를 문자열로 형변환하여 기존 numbers에 치환