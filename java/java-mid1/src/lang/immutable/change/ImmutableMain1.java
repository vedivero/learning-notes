package lang.immutable.change;

public class ImmutableMain1 {
    public static void main(String[] args) {
        ImmutableObj immutableObj1 = new ImmutableObj(10);
        ImmutableObj immutableObj2 = immutableObj1.add(30);

        System.out.println(immutableObj2.getValue());
    }
}
