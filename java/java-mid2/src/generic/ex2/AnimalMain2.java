package generic.ex2;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalMain2 {
    public static void main(String[] args) {
        Animal animal = new Animal("동물",0 );
        Dog dog = new Dog("멍멍이", 100);
        Cat cat = new Cat("야옹이",50);

        Box<Object> animalBox = new Box<>();
        animalBox.setValue(animal);
        animalBox.setValue(dog);
        animalBox.setValue(cat);

        Animal findAnimal = (Animal) animalBox.getValue();
        System.out.println("findAnimal = " + findAnimal);
    }
}
