package mid2.generic.ex4;

import mid2.generic.animal.Animal;
import mid2.generic.animal.Cat;
import mid2.generic.animal.Dog;

public class MethodMain3 {

    public static void main(String[] args) {

        Dog dog = new Dog("멍멍이1", 100);
        Cat cat = new Cat("야옹이", 100);

        ComplexBox<Dog> hospital = new ComplexBox<>();
        hospital.setAnimal(dog);

        Cat returnCat = hospital.printAndReturn(cat);
        System.out.println("returnCat = " + returnCat);
    }
}
