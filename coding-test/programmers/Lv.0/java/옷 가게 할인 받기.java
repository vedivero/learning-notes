//머쓱이네 옷가게는 10만 원 이상 사면 5%, 30만 원 이상 사면 10%, 50만 원 이상 사면 20%를 할인해줍니다.
//구매한 옷의 가격 price가 주어질 때, 지불해야 할 금액을 return 하도록 solution 함수를 완성해보세요.
class Solution {
    public int solution(int price) {

        double discount_5 = 0.05;
        double discount_10 = 0.10;
        double discount_20 = 0.20;

        if (price >= 500_000) {
            return (int)(price * (1 - discount_20));
        } else if (price >= 300_000) {
            return (int)(price * (1 - discount_10));
        } else if (price >= 100_000) {
            return (int)(price * (1 - discount_5));
        } else {
            return price;
        }
    }
}