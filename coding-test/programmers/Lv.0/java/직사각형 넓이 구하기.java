import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[][] param = new int[][] {
                { 1, 1 },
                { 2, 1 },
                { 2, 2 },
                { 1, 2 }
        };

        int result = solution(param);
        System.out.println("result = " + result);
    }

    // 평면 좌표 값이 들어 있는 매개 변수로 전달된 배열의 값을 사용해 사각형의 크기를 구하는 문제
    public static int solution(int[][] dots) {

        // x축의 최대 값과 y축의 최대 값을 곱하면
        // 사각형의 넓이를 구할 수 있기 때문에
        // 최소 값, 최대 값을 비교하기 위한 초기 값을 설정
        // 반복문을 순회하며 큰 값, 작은 값을 찾아 나감
        int max_x = Integer.MIN_VALUE;
        int min_x = Integer.MAX_VALUE;
        int max_y = Integer.MIN_VALUE;
        int min_y = Integer.MAX_VALUE;

        // 2차원 배열의 길이만큼 순회하며 x값과 y값의 최대, 최소 값을 비교
        for (int i = 0; i < dots.length; i++) {

            // 값 비교를 위해 i번째의 x값이 위치한 [][0] 값을 추출
            int x = dots[i][0];
            // 값 비교를 위해 i번째의 y값이 위치한 [][1] 값을 추출
            int y = dots[i][1];

            // i번째 값을 비교
            if (x > max_x)
                max_x = x;
            if (x < min_x)
                min_x = x;
            if (y > max_y)
                max_y = y;
            if (y < min_y)
                min_y = y;

        }

        // 최대 값에서 최고 값을 빼면 한 변의 길이를 알 수 있음
        int width = max_x - min_x;
        int height = max_y - min_y;

        return width * height;
    }

}