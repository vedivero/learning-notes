//문제 설명
//정수 배열 numbers가 매개변수로 주어집니다.
//numbers의 원소 중 두 개를 곱해 만들 수 있는 최댓값을 return하도록 solution 함수를 완성해주세요.

//입출력 예
//numbers	                result
//[1, 2, 3, 4, 5]	        20
//[0, 31, 24, 10, 1, 9]	    744

class Solution {
    public int solution(int[] numbers) {

        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = 0; j < numbers.length-1; j++) {
                if (numbers[j] < numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        return numbers[0] * numbers[1];
    }
}