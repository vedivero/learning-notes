package mid2.generic.ex2;

import mid2.generic.animal.Animal;
import mid2.generic.animal.Cat;
import mid2.generic.animal.Dog;

public class AnimalMain1 {
    public static void main(String[] args) {
        Animal animal = new Animal("동물", 0);
        Dog dog = new Dog("멍멍이", 50);
        Cat cat = new Cat("야옹이", 20);

        Box<Dog> dogBox = new Box<>();
        dogBox.setValue(dog);
        Dog findDog = dogBox.getValue();
        System.out.println("findDog = " + findDog);

        System.out.println(" ");
        Box<Cat> catBox = new Box<>();
        catBox.setValue(cat);
        Cat findCat = catBox.getValue();
        System.out.println("findCat = " + findCat);

        System.out.println(" ");
        Box<Animal> animalBox = new Box<>();
        animalBox.setValue(animal);
        Animal findAnimal = animalBox.getValue();
        System.out.println("findAnimal = " + findAnimal);

    }
}
