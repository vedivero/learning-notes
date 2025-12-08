package array.test;

public class MaxValueInArray {

    public static void main(String[] args) {

        int[] array = {11, 23, 42, 52, 13};

        int max = array[0];
        for (int i : array) {
            if(i > max) max = i;
        }

        System.out.println("max = " + max);
    }
}
