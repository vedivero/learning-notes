package control.test;

public class Triangle {
    public static void main(String[] args) {

        /*

         *
         *   *
         *   *   *
         *   *   *   *
         *   *   *   *   *

         * */

//        int length = 1;
//        for (int i = 1; i <= 5; i++) {
//            for (int j = 0; j < length; j++) {
//                System.out.print("*");
//            }
//            length++;
//            System.out.println(" ");
//        }

        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }

    }
}
