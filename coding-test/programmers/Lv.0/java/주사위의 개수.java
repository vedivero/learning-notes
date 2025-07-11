//문제 설명
//머쓱이는 직육면체 모양의 상자를 하나 가지고 있는데
// 이 상자에 정육면체 모양의 주사위를 최대한 많이 채우고 싶습니다.
// 상자의 가로, 세로, 높이가 저장되어있는 배열 box와
// 주사위 모서리의 길이 정수 n이 매개변수로 주어졌을 때,
// 상자에 들어갈 수 있는 주사위의 최대 개수를 return 하도록 solution 함수를 완성해주세요.

// 입출력 예
// box[WxDxH]      	n[정육면체]	    result
// [1, 1, 1]    	1	            1
// [10, 8, 6]	    3	            12
class Solution {
    public int solution(int[] box, int n) {
        int totalCount = 1;
        for (int i : box) {
            totalCount *= i / n;
        }
        return totalCount;
    }
}
// 한 변의 길이가 3이기 때문에
// 주어진 각 길이(가로, 세로, 높이)를 3으로 각각 나눈 값을 곱해서 개수를 산출
// 정수형 타입으로 계산하면 소수 점은 버려지기 때문에 정수형 타입으로 계산