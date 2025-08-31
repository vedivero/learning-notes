package operator.v2;

public class ShapeConversionOperation {
    public static void main(String[] args) {
        System.out.printf("%d\n", 5 / 2);
        System.out.printf("%f\n", 5.0 / 2);
        System.out.printf("%f\n", (double) 5 / 2);
        System.out.printf("%f\n", (double) (5 / 2));
        System.out.printf("%d, %d\n", 256, (byte) 256);
    }
}
