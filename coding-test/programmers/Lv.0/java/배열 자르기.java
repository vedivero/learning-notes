//정수 배열 numbers와 정수 num1, num2가 매개변수로 주어질 때,
// numbers의 num1번 째 인덱스부터 num2번째 인덱스까지 자른 정수 배열을 return 하도록 solution 함수를 완성해보세요.
//입출력 예
//numbers	        num1	num2	result
//[1, 2, 3, 4, 5]	1	    3	    [2, 3, 4]
//[1, 3, 5]	        1	    2	    [3, 5]
class Solution{
    public int[] solution(int[] numbers, int num1, int num2) {
        int size = num2 - num1 + 1;
        int[] answer = new int[size];
        for (int i = 0; i < size; i++) {
            answer[i] = numbers[num1 + i];
        }
        return answer;
    }
}
// 시작 인덱스와 마지막 인덱스의 차이가 배열의 길이가 됨
// 새롭게 생성한 배열의 0번째 인덱스 부터, 반복문을 사용하여 값을 대입
// 매개 변수로 받은 number배열의 num1+1 인덱스부터 1씩 증가시키며 값을 대입


import java.util.Arrays;
class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        return Arrays.copyOfRange(numbers, num1, num2 + 1);
    }
}
// 자바의 slice메서드
// 매개변수	    의미
// original	    복사할 원본 배열
// from	        복사를 시작할 인덱스 (포함)
// to	        복사를 끝낼 인덱스 (미포함)
