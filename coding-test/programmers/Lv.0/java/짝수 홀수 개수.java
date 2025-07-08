//정수가 담긴 리스트 num_list가 주어질 때,
// num_list의 원소 중 짝수와 홀수의 개수를 담은 배열을 return 하도록 solution 함수를 완성해보세요
//입출력 예
//num_list	1.[1, 2, 3, 4, 5] / 2.[1, 3, 5, 7]
//result	1.[2, 3] / 2.[0, 4]

class Solution {
    public int[] solution(int[] num_list) {

        int[] answer = new int[2];
        int[] odd = {};
        int[] even = {};

        for (int i : num_list) {
            if (i % 2 == 0) {
                answer[0]++;
            } else {
                answer[1]++;
            }
        }
        return answer;
    }
}


// 또 다른 풀이 방법
class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];

        for(int i = 0; i < num_list.length; i++)
            answer[num_list[i] % 2]++;

        return answer;
    }
}
// 짝수, 홀수 구하는 문제는 해당 값을 2로 나누었을 때,
// 나머지 값이 0이냐, 1이냐로 판단할 수 있음
// 즉, 나머지 연산의 결과가 0, 1뿐임
// 0,1 뿐만이라는 점을 활용하여
// answer라는 정수형 배열의 인덱스를 num_list의 각 요소를 2로 나눈 값으로 처리할 수 있음
// num_list의 [i]번째 요소를 2로 나누어 나머지가 0이면, answer[0]의 값을 후위연산으로 1을 증가 시킴 ++;
// 반대로 
// num_list의 [i]번째 요소를 2로 나누어 나머지가 1이면, 홀수이므로 answer[1]의 값을 후위연산으로 1을 증가 시킴 ++;
// 즉, 짝수인 경우는 (num_list[i] % 2)의 결과가 0이니까, 0번 index의 값이 1증가 되고
// 홀수인 경우는 (num_list[i] % 2)의 결과가 1이니까, 1번 index의 값이 1증가 되므로
// 짝수 개수와 홀수 개수를 담은 answer배열이 반환됨.