package mid2.generic.ex4;

import mid2.generic.animal.Cat;
import mid2.generic.animal.Dog;

public class MethodMain2 {

    public static void main(String[] args) {

        Dog dog = new Dog("멍멍이1", 100);
        Cat cat = new Cat("야옹이", 100);

        AnimalMethod.checkup(dog);
        AnimalMethod.getBigger(dog, new Dog("멍멍이2", 200));

        AnimalMethod.checkup(cat);
        AnimalMethod.getBigger(cat, new Cat("야옹이2", 50));

    }
}
