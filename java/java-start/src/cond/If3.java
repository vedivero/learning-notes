package cond;

public class If3 {
    public static void main(String[] args) {

        int age = 8;

        if (age >= 18) {
            System.out.println("성인입니다");
        }
        if (age >= 8 && age <= 13) {
            System.out.println("초등학생 입니다");
        }
        if (age >= 14&& age <= 16) {
            System.out.println("중학생 입니다");
        }
        if (age >= 17 && age <= 20) {
            System.out.println("고등학생 입니다");
        }
        if (age >= 20) {
            System.out.println("대학생 입니다");
        }
    }
}
