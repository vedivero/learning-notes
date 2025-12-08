package array.test;

import java.util.Arrays;

public class SumOfRowColumn {



    public static void main(String[] args) {

        int[][] array = new int[][]{
            {10, 20, 30, 0},
            {40, 50, 60, 0},
            {0, 0, 0, 0}
        };

        // row
        // i = 행 기준
        // 제일 끝 합산 결과를 표출하는 [i][3]인덱스에
        // [i]행의 [j]열의 값을 순서대로 합하기
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][3] += array[i][j];
            }
        }


        // column
        // i = 열 기준
        // 값을 표출해야하는 [2][] 줄에만 대입하면 됨
        // j행의 i번 열의 값을 순회하며 더한 값을
        // 마지막 행인 2행의 i번째에 대입
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                array[2][i] += array[j][i];
            }
        }

        System.out.println(Arrays.deepToString(array));

    }

}
