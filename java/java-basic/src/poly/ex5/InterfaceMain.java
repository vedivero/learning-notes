package poly.ex5;

public class InterfaceMain {
    public static void main(String[] args) {
        // 인터페이스는 인스턴스 생성 불가
        //InterfaceAnimal interfaceAnimal = new InterfaceAnimal();

        Dog dog = new Dog();
        Cat cat = new Cat();
        Cow cow = new Cow();

        soundAnimal(dog);
        soundAnimal(cat);
        soundAnimal(cow);
    }

    private static void soundAnimal(InterfaceAnimal animal) {
        animal.sound();
    }
}
