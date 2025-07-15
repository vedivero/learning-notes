//문제 설명
//소인수분해란 어떤 수를 소수들의 곱으로 표현하는 것입니다.
// 예를 들어 12를 소인수 분해하면 2 * 2 * 3 으로 나타낼 수 있습니다.
// 따라서 12의 소인수는 2와 3입니다.
// 자연수 n이 매개변수로 주어질 때 n의 소인수를 오름차순으로 담은 배열을 return하도록 solution 함수를 완성해주세요.

// 입출력      예
// n	    result
// 12	    [2, 3]
// 17	    [17]
// 420	    [2, 3, 5, 7]
class Solution {
    public int[] solution(int n) {

        int[] temp = new int[100];
        int count = 0;

        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                temp[count++] = i;
                while (n % i == 0) {
                    n /= i;
                }
            }
        }

        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }
        return result;
    }
}

//n을 2로 나누어갈때 나오는 모든 인수를 저장하기 위한 임시 배열을 크기를 넉넉하게 선언
//2로 나누어질 때 마다, count를 세고, count가 해당 인수의 저장될 인덱스가 됨
//n을 2 ~ n까지의 숫자로 나누고 나머지 값이 0이 되면,
//그 n의 숫자를 내부 반복문을 통해, n을 i로 나누었을 때, 0이 될 때 까지 나눔
//즉, 더 이상 나눌 수 없는 '인수'를 찾기 위한 반복문

//소인수로 발견된 count만큼의 숫자 길이를 가진 result 배열에 count길이 만큼의 temp 값을 담으면,
//인수가 아닌, 소수인 인수가 정답 배열에 대입됨