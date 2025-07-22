package generic.ex5;

import generic.animal.Animal;

public class WildcardEx {
    static <T> void printGenericV1(Box<T> box) {
        System.out.println("T = " + box.getValue());
    }

    static void printWildcardV1(Box<?> box) {
        System.out.println("? = " + box.getValue());
    }

    static <T extends Animal> void prirntGenericV2(Box<T> box) {
        T t = box.getValue();
        System.out.println("t.getName() = " + t.getName());
    }

    static void prirntWildcardV2(Box<? extends Animal> box) {
        Animal animal = box.getValue();
        System.out.println("animal.getName() = " + animal.getName());
    }

    static <T extends Animal> T prirntAndReturnGenericV3(Box<T> box) {
        T t = box.getValue();
        System.out.println("t.getName() = " + t.getName());
        return t;
    }

    static Animal printAndReturnWildcard(Box<? extends Animal> box) {
        Animal animal = box.getValue();
        System.out.println("animal = " + animal);
        return animal;
    }
}
