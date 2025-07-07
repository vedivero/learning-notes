//정수 배열 numbers가 매개변수로 주어집니다. numbers의 원소의 평균값을 return하도록 solution 함수를 완성해주세요.
class Solution {
    public double solution(int[] numbers) {
        double sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum/numbers.length;
    }
}

//평균 값을 구해야 하기 때문에 소수점을 담을 수 있는 double형으로 변수를 선언
//향상된 반복문을 통해 각 배열의 요소를 sum이라는 double형 변수에 합산
//합산한 총 수를 배열의 길이 만큼 나누면, 배열의 개수로 나누는 것이기에 평균 값을 구할 수 있음