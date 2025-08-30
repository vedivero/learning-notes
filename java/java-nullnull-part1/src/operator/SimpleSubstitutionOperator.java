package operator;

public class SimpleSubstitutionOperator {
    public static void main(String[] args) {
        int a = 10;
        int b = 30;
        final int c = 40;   // read only
        b = a;
        //c = 50;
        System.out.println("b = " + b);
    }
}
