package generic.ex5;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

public class WildcardMain2 {

    public static void main(String[] args) {
        Box<Object> objBox = new Box<>();
        Box<Animal> animalBox = new Box<>();
        Box<Dog> dogBox = new Box<>();
        Box<Cat> catBox = new Box<>();

        //Animal을 포함한 상위 타입만 전달 가능
        writeBox(objBox);
        writeBox(animalBox);
        //writeBox(dogBox);
        //writeBox(catBox);

        Animal animal = animalBox.getValue();
        System.out.println("animal = " + animal);
    }

    static void writeBox(Box<? super Animal> box) {
        box.setValue(new Dog("멍멍이", 200));
    }
}
