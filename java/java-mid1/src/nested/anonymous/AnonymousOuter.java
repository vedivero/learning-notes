package nested.anonymous;

import nested.local.Printer;

public class AnonymousOuter {
    private int outInstance = 3;

    public void process(int paramVar) {
        int localVar = 1;

        Printer printer = new Printer() {

            int value = 0;

            @Override
            public void print() {
                System.out.println("value = " + value);
                System.out.println("localVar = " + localVar);
                System.out.println("paramVar = " + paramVar);
                System.out.println("outInstance = " + outInstance);
            }
        };
        
        printer.print();
        System.out.println("printer.getClass() = " + printer.getClass());
    }

    public static void main(String[] args) {
        AnonymousOuter localOuterV2 = new AnonymousOuter();
        localOuterV2.process(2);
    }
}
