package array.ex;

import java.util.Scanner;

public class ArrayEx8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("학생 수를 입력하세요. : ");
        int studentCount = scanner.nextInt();

        int[][] scores = new int[studentCount][3];
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
            for (int column = 0; column < scores[row].length; column++) {
                totalScore = scores[row][column];
            }
            double average = (double) totalScore / scores[row].length;
            System.out.println((row+1) + "번 학생의 총점 : " + totalScore + ", 평균 : " + average);
        }
    }
}
