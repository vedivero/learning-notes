package generic.ex5;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

public class WildcardMain1 {
    public static void main(String[] args) {
        Box<Object> objectBox = new Box<>();
        Box<Dog> dogBox = new Box<>();
        Box<Cat> catBox = new Box<>();

        dogBox.setValue(new Dog("멍멍이", 200));

        WildcardEx.printGenericV1(dogBox);
        WildcardEx.printWildcardV1(dogBox);

        WildcardEx.prirntGenericV2(dogBox);
        WildcardEx.prirntWildcardV2(dogBox);

        Dog dog = WildcardEx.prirntAndReturnGenericV3(dogBox);
        Animal animal = WildcardEx.printAndReturnWildcard(dogBox);

        System.out.println("dog = " + dog);

    }
}
