package static2;

public class DecoMain1 {
    public static void main(String[] args) {
        String s = "hello Java";
        DecoUtil1 decoUtil1 = new DecoUtil1();
        String deco = decoUtil1.deco(s);

        System.out.println(s);
        System.out.println(deco);
    }
}
