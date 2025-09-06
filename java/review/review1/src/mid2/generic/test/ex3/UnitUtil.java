package mid2.generic.test.ex3;

import mid2.generic.test.ex3.unit.BioUnit;

public class UnitUtil {

    public static <T extends BioUnit<T>> T maxHp(T t1, T t2) {
        return t1.getHp() > t2.getHp() ? t1 : t2;
    }

}
