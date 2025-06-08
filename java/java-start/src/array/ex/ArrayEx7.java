package array.ex;

import java.util.Scanner;

public class ArrayEx7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] scores = new int[4][3];
        String[] subjects = {"국어", "영어", "수학"};

        for (int row = 0; row < scores.length; row++) {
            System.out.println((row + 1) + "번 학생의 성적을 입력하세요.");

            for (int column = 0; column < scores[row].length; column++) {
                System.out.print(subjects[column]+" 성적을 입력하세요 : ");
                scores[row][column] = scanner.nextInt();
            }
        }


        for (int row = 0; row < scores.length; row++) {
            int totalScore = 0;
            for (int column = 0; column < scores[column].length; column++) {
                totalScore = scores[row][column];
            }
            double average = (double) totalScore / scores[row].length;
            System.out.println((row+1) + "번 학생의 총점 : " + totalScore + ", 평균 : " + average);
        }
    }
}
