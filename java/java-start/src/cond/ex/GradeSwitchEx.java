package cond.ex;

public class GradeSwitchEx {
    public static void main(String[] args) {
        char grade = 'B';

        switch (grade) {
            case 'A' :
                System.out.println("최고의 성과입니다.");
                break;
            case 'B':
                System.out.println("탁월한 성과입니다.");
                break;
            case 'C':
                System.out.println("좋은 성과입니다.");
                break;
            case 'D':
                System.out.println("준수한 성과입니다.");
                break;
            case 'E':
                System.out.println("노력이 필요합니다.");
                break;
            case 'F':
                System.out.println("불합격입니다.");
                break;
            default:
                System.out.println("잘못된 점수입니다.");
        }
    }
}
