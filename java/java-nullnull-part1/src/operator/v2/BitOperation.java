package operator.v2;

public class BitOperation {
    public static void main(String[] args) {
        int data = 0x11223344;
        System.out.printf("%d\n", data);
        System.out.printf("%08X\n", data);
        System.out.printf("%08X\n", data & 0xFFFF0000);
        System.out.printf("%08X\n", data | 0xFFFF0000);
        System.out.printf("%08X\n", data ^ 0xFFFF0000);
        System.out.printf("%08X\n", ~data);

    }
}
