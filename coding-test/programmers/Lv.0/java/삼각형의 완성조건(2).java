public class Main {
    public static void main(String[] args) {

        // int[] sides = {3, 6};
        int[] sides = { 11, 7 };

        System.out.println(solution(sides));
    }

    public static int solution(int[] sides) {

        // 두 변의 길이가 주어질 때, 마지막 한 변이 가질 수 있는 정수 길이의 개수를 구하는 식
        // a + b - |a - b| - 1

        // 길이가 2인 배열로 고정되어 있기 때문에
        // 매개 변수로 전달된 배열의 0번 인덱스의 값과 1번 인덱스의 값을 더한다
        int leftCond = sides[0] + sides[1];
        // 0번 인덱스와 1번 인덱스의 차이를 절대 값으로 구한다
        int rightCond = Math.abs(sides[0] - sides[1]);

        // 도출한 값을 공식과 같이 정리하여 계산한다
        return leftCond - rightCond - 1;

    }
}