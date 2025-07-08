//"*"의 높이와 너비를 1이라고 했을 때,
//"*"을 이용해 직각 이등변 삼각형을 그리려고합니다.
//정수 n 이 주어지면 높이와 너비가 n 인 직각 이등변 삼각형을 출력하도록 코드를 작성해보세요.
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
// "*"를 이용하여 1부터 n의 수 만큼 해당 문자를 출력해서 트리 형태를 만드는 문제
// Scanner를 통해 n을 사용자로 부터 입력 받는다
// n의 수 만큼 반복문을 사용해서 화면에 출력하는데, 단순한 반복문이 아닌 이중반복문을 사용
// 첫 번째 반복문에서는 n만큼 반복을 하고
// 두 번째 반복문에서는 0부터 시작해 1씩 증가하는 i만큼의 "*" 문자를 출력 한다.
// 내부 중첩문의 한 싸이클이 종료될 때 마다, 개행을 해서 이등변 삼각형 형태로 출력되도록 처리

// String Class의 repeat함수를 사용한 풀이 방법
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("*".repeat(i));
        }
    }
}
// i의 초기 값을 1로 설정하고, repeat함수를 사용하여 n만큼 해당 문자를 반복