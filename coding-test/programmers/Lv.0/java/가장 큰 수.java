// 문제 설명
// 정수 배열 array가 매개변수로 주어질 때,
// 가장 큰 수와 그 수의 인덱스를 담은 배열을 return 하도록 solution 함수를 완성해보세요.

// 입출력 예
// array	        result
// [1, 8, 3]	    [8, 1]
// [9, 10, 11, 8]	[11, 2]

class Solution {
    public int[] solution(int[] array) {
        int max = array[0];
        int index = 0;

        for(int i=1; i<array.length; i++){
            if (max < array[i]) {
                max = array[i];
                index = i;
            }
        }

        int[] answer = new int[2];
        answer[0] = max;
        answer[1] = index;
        return answer;

    }
}