package cond.ex;

public class ScoreEx {
    public static void main(String[] args) {
        int score = 85;

        if (score >= 90) {
            System.out.println("A학점");
        } else if (score >= 80) {
            System.out.println("B학점");
        } else if (score >= 70) {
            System.out.println("C학점");
        } else if (score >= 60) {
            System.out.println("D학점");
        } else {
            System.out.println("F학점");
        }
    }
}

