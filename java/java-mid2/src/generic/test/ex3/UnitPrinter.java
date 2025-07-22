package generic.test.ex3;

import generic.test.ex3.unit.BioUnit;
import generic.test.ex3.unit.Marine;
import generic.test.ex3.unit.Zergling;

public class UnitPrinter {
    public static <T extends BioUnit> void printV1(Shuttle<T> t1) {
        T unit = t1.out();
        System.out.println("unit.getName() = " + unit.getName() + ", HP = " + unit.getHp());
    }

    public static void printV2(Shuttle<? extends BioUnit> t1) {
        BioUnit unit = t1.out();
        System.out.println("unit.getName() = " + unit.getName() + ", HP = " + unit.getHp());
    }
}
