package operator.v2.test;

import java.util.Scanner;

public class MinusOperation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("뺄셈 할 두 숫자를 입력하세요.");

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        System.out.printf("%d\n",~num2+1);
        System.out.printf("%08X\n",num1 + (~num2+1));
        System.out.printf("%d\n",num1 + (~num2+1));

        int result = num1 + (~num2 + 1);
        System.out.println("result = " + result);
    }
}
