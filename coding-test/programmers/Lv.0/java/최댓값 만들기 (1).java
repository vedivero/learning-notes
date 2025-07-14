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
//자바 util의 Array.sort()를 사용하여 정렬하여 문제를 풀 수도 있음.
//매개 변수로 주어지는 numbers의 각 요소를 순회하며 값을 비교해서
//내림차순으로 값이 정렬되도록 처리
//이중반복문을 사용
//배열의 길이만큼 반복을 진행
//i번째 인덱스와 i+1인덱스를 비교해서 i+1인덱스가 더 크면,
//i+1인덱스를 i번째 인덱스로 이동