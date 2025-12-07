package control.test;

public class Pyramid {
    public static void main(String[] args) {
        /*
                         *
                     *   *   *
                 *   *   *   *   *
             *   *   *   *   *   *   *
         *   *   *   *   *   *   *   *   *

         * */

        /*int length = 5;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < length; j++) {
                if (j < 4 - i) System.out.print("\t");
                else  System.out.print("*\t");
            }
            length++;
            System.out.println(" ");
        }*/
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 + i; j++) {
                if (j < 4 - i) System.out.print("\t");
                else System.out.print("*\t");
            }
            System.out.println(" ");
        }
    }
}
