package generic.ex2;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalMain1 {
    public static void main(String[] args) {
        Animal animal = new Animal("동물",0 );
        Dog dog = new Dog("멍멍이", 100);
        Cat cat = new Cat("야옹이",50);

        Box<Object> dogBox = new Box<>();
        dogBox.setValue(dog);
        Dog findDog = (Dog) dogBox.getValue();
        System.out.println("findDog = " + findDog);

        Box<Object> catBox = new Box<>();
        catBox.setValue(cat);
        Object findCat = catBox.getValue();
        System.out.println("findCat = " + findCat);

        Box<Object> animalBox = new Box<>();
        animalBox.setValue(animal);
        Object findAnimal = animalBox.getValue();
        System.out.println("findAnimal = " + findAnimal);
    }
}
