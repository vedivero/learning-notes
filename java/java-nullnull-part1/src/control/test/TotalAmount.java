package control.test;

public class TotalAmount {

    public static void main(String[] args) {

        int sum = 0;

        for (int i = 1; i <= 10; i++) {
            sum += i;
        }

        System.out.println("sum = " + sum);

        int total = 0;
        int num = 1;
        while (num <= 10) {
            total += num;
            num++;
        }

        System.out.println("total = " + total);
    }
}
