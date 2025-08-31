package operator.v2;

public class BitShiftOperation {
    public static void main(String[] args) {
        int data = 128;
        System.out.printf("%d\n", data << 1);
        System.out.printf("%d\n", data >> 2);
        System.out.printf("%d\n", -data >> 2);
        System.out.printf("%d\n", -data >>> 2);
        System.out.printf("%08X\n", -data >>> 2);
    }
}
