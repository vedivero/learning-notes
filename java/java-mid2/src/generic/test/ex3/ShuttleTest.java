package generic.test.ex3;

import generic.test.ex3.unit.Marine;

public class ShuttleTest {
    public static void main(String[] args) {
        Shuttle<Marine> shuttle1 = new Shuttle<>();
        shuttle1.in(new Marine("마린", 40));
        shuttle1.showInfo();

        Shuttle<Marine> shuttle2 = new Shuttle<>();
        shuttle1.in(new Marine("저글링", 35));
        shuttle1.showInfo();

        Shuttle<Marine> shuttle3 = new Shuttle<>();
        shuttle1.in(new Marine("질럿", 100));
        shuttle1.showInfo();
    }
}
