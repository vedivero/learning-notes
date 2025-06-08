package array;

public class EnhancedFor1 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            System.out.print(number);
        }
        System.out.println();
        for (int number : numbers) {
            System.out.print(number);
        }
    }
}
