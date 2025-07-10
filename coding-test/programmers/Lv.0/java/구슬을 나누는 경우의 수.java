//문제 설명
//머쓱이는 구슬을 친구들에게 나누어주려고 합니다.
// 구슬은 모두 다르게 생겼습니다.
// 머쓱이가 갖고 있는 구슬의 개수 balls와 친구들에게 나누어 줄 구슬 개수 share이 매개변수로 주어질 때,
// balls개의 구슬 중 share개의 구슬을 고르는 가능한 모든 경우의 수를 return 하는 solution 함수를 완성해주세요.

//  입출력   예
//  balls	share	result
//  3   	2   	3
//  5	    3	    10
class Solution {
    public int solution(int balls, int share) {
        double numerator = 1;
        double denominator = 1;

        for (int i = share; i > 0; i--) {
            numerator *= balls;
            denominator *= i;
            balls--;
        }

        double result = numerator / denominator;
        return (int)result;
    }
}

//분자, 분모를 1로 초기화
//반복 초기 값을 선택 개수로 설정
//반복 종료 값(조건식)은 0보다 크도록 설정
//반복할 때 마다 초기 값을 1씩 감소

// 분자에는 현재 balls 값을 곱한 뒤, balls를 1 감소
// 분모에는 현재 반복 값 i를 곱해 나감

// 전체 경우의 수는 선택하지 않은 경우를 제외하고,
// 분자 값을 분모로 나누면 조건에 맞는 조합의 수를 구할 수 있음

// 모든 경우의 수를 전부 곱하면 숫자가 너무 커져 오버플로우가 발생할 수 있음
// 필요한 범위만 계산하여 효율적으로 조합을 구함
// 즉, 구하려는 조합의 수만 계산하고, 계산하지 않아도 되는 부분은 제외하여 불필요한 연산을 줄임
