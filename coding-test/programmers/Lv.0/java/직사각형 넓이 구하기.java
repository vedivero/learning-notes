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

    //
    public static int solution(int[][] dots) {

        int max_x = Integer.MIN_VALUE;
        int min_x = Integer.MAX_VALUE;
        int max_y = Integer.MIN_VALUE;
        int min_y = Integer.MAX_VALUE;

        for (int i = 0; i < dots.length; i++) {

            int x = dots[i][0];
            int y = dots[i][1];
            if (x > max_x)
                max_x = x;
            if (x < min_x)
                min_x = x;
            if (y > max_y)
                max_y = y;
            if (y < min_y)
                min_y = y;

        }

        int width = max_x - min_x;
        int height = max_y - min_y;

        return width * height;
    }

}