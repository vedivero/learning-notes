import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] numbers = new int[]{1, 2, -3, 4, -5};

        int result = solution(numbers);
        System.out.println("result = " + result);
    }

    public static int solution(int[] numbers) {

        // 가장 큰 수끼리의 곱을 하기 위해 매개 변수로
        // 전달되는 값을 오름차순을 정렬
        Arrays.sort(numbers);

        int len = numbers.length;

        // 오름차순으로 정렬된 배열의 가장 큰 수인 마지막 인덱스와
        // 다음으로 큰 수인 인덱스의 곱을 구함
        int large = numbers[len - 1] * numbers[len - 2];
        // 음수 * 음수 = 양수이기 때문에
        // 이 케이스도 비교해야 함
        int small = numbers[0] * numbers[1];

        // 가장 큰 두 수의 곱과 가장 작은 두 수의 곱을 비교하여 큰 수를 반환
        return Math.max(large, small);

    }
}