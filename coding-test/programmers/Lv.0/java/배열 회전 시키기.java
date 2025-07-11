//문제 설명
//정수가 담긴 배열 numbers와 문자열 direction가 매개변수로 주어집니다.
// 배열 numbers의 원소를 direction방향으로 한 칸씩 회전시킨 배열을 return하도록 solution 함수를 완성해주세요.

//입출력 예
//numbers	                    direction	    result
//[1, 2, 3]	                      "right"	    [3, 1, 2]
//[4, 455, 6, 4, -1, 45, 6]	      "left"	    [455, 6, 4, -1, 45, 6, 4]
class Solution {
    public int[] solution(int[] numbers, String direction) {
        int n = numbers.length;
        int[] answer = new int[n];

        if (direction.equals("right")) {
            answer[0] = numbers[n - 1];
            for (int i = 0; i < n - 1; i++) {
                answer[i + 1] = numbers[i];
            }
        } else if (direction.equals("left")) {
            answer[n - 1] = numbers[0];
            for (int i = 1; i < n; i++) {
                answer[i - 1] = numbers[i];
            }
        }
        return answer;
    }
}
// 매개 변수로 전달되는 다이렉션 값에 따라 배열의 위치를 다르게 설정

// 방향을 오른쪽으로 이동시키는 경우.
// 0번째 인덱스 -> 1번째 인덱스 ... 마지막 인덱스 -> 첫번째 인덱스가 됨
// 즉, 마지막 인덱스를 0번째 인덱스에 먼저 대입하고, 현재 인덱스 + 1이 되어야 함

// 방향을 왼쪽으로 이동시키는 경우.
// 우선,
// 왼쪽으로 이동되면, 첫 번째 인덱스가 마지막 인덱스로 이동되어 져야 함.
// 이동 처리 후 저장할 배열의 마지막 인덱스에 이동 전의 0번째 인덱스의 값을 대입.
// [1][][][][5]
// [ ][][][][1] 1이 왼쪽으로 밀려 마지막 인덱스로 이동 됨.
// 나머지 인덱스는 기존 위치에서 -1만 해주면 됨.
// 반복 문의 조건식을 배열의 길이만큼 설정하여


// 방향이 왼쪽인 경우,
// 0번째 인덱스 <- 1번째 인덱스 ... 첫번째 인덱스 -> 마지막 인덱스가 됨
// 첫번째 인덱스인 0번 인덱스를 마지막 인덱스에 대입하고, 나머지 인덱스는 (현재 인덱스 - 1)이 되어야 함
// 이동시킨 인덱스를 제외하고, 나머지 인덱스를 -1 만큼 인덱스 위치를 감소시켜서 이동시키면 되기 때문에
// 반복문을 사용해서 이동 처리 후 저장할 배열[i-1]에 [i]위치의 값을 대입