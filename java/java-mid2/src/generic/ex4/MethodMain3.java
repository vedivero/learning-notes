package generic.ex4;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

public class MethodMain3 {
    public static void main(String[] args) {
        Dog dog = new Dog("멈멍이", 100);
        Cat cat = new Cat("야옹이", 50);

        ComplexBox<Animal> hospital = new ComplexBox<>();
        hospital.setAnimal(dog);

        Cat returnCat = hospital.printAndReturn(cat);
        System.out.println("returnCat = " + returnCat);
    }
}
