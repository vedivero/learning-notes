package lang.string.chaining;

public class MethodChainingMain2 {
    public static void main(String[] args) {
        ValueAdder valueAdder = new ValueAdder();
        ValueAdder adder1 = valueAdder.add(1);
        ValueAdder adder2 = adder1.add(2);
        ValueAdder adder3 = adder2.add(3);

        int result = valueAdder.getValue();
        System.out.println("result = " + result);

        System.out.println("result = " + adder1);
        System.out.println("result = " + adder2);
        System.out.println("result = " + adder3);

    }
}
