// 머쓱이네 양꼬치 가게는 10인분을 먹으면 음료수 하나를 서비스로 줍니다.
// 양꼬치는 1인분에 12,000원, 음료수는 2,000원입니다. 정수 n과 k가 매개변수로 주어졌을 때,
// 양꼬치 n인분과 음료수 k개를 먹었다면 총얼마를 지불해야 하는지 return 하도록 solution 함수를 완성해보세요.

//입출력 예
// n	k	result
// 10	3	124,000
// 64	6	768,000
class Solution {
    public int solution(int n, int k) {
        int serviceCount = n / 10;
        int paidDrinkCount = k - serviceCount;

        if (paidDrinkCount < 0) paidDrinkCount = 0;

        return (n * 12_000) + (paidDrinkCount * 2_000);
    }
}
// 10인분 마다, 음료수 하나를 서비스로 처리
// n인분을 10으로 나누어서 서비스 개수를 구함
// int 타입이기 때문에 소수점은 버려짐
// 서비스 개수를 이용하여, (음료수 개수 - 서비스 개수)로 음료수 값을 구하기
// 양꼬치 n인분에 가격(12,000)을 곱하고, 서비스 개수를 제외한 음료수 개수 k에 가격을 곱해서
// 총 비용을 산정