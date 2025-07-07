// 피자를 7조각으로 잘라 판매하는 가게
// 모든 사람이 1조각씩은 먹어야 함
class Solution{
    public int solution(int n){
        int answer = Math.ceil(double(n/7));
        return answer;
    }
}

//n명이 한 조각 씩 먹으려면, n조각이 필요.
//피자 한 판은 7조각이 배달.
//인원 수를 피자 조각(7조각)으로 나눈 실수값을 올림 처리.
//모든 인원이 1조각 씩 먹을 수 있는 최소 피자 판 수가 구해짐
