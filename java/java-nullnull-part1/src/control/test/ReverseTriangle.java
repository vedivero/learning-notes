package control.test;

public class ReverseTriangle {

    public static void main(String[] args) {

        /*

                        *
                    *   *
                *   *   *
            *   *   *   *
        *   *   *   *   *

        * */

        int length = 4;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j < length) System.out.print("\t");
                else  System.out.print("*\t");
            }
            length--;
            System.out.println(" ");
        }
    }

}