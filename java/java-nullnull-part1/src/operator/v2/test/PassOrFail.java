package operator.v2.test;

import java.util.Scanner;

public class PassOrFail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("점수를 입력하세요. :");
        int score = sc.nextInt();
        String result = score >= 80 ? "합격" : "불합격";
        System.out.println("result = " + result);
    }
}
