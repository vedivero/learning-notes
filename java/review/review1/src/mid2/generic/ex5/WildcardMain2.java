package mid2.generic.ex5;

import mid2.generic.animal.Animal;
import mid2.generic.animal.Cat;
import mid2.generic.animal.Dog;

public class WildcardMain2 {

    public static void main(String[] args) {

        Box<Object> objectBox = new Box<>();
        Box<Animal> animalBox = new Box<>();
        Box<Dog> dogBox = new Box<>();
        Box<Cat> catBox = new Box<>();

        writeBox(objectBox);
        writeBox(animalBox);
        //writeBox(dogBox);
        //writeBox(catBox);

        Animal animalBoxValue = animalBox.getValue();
        System.out.println("animalBoxValue = " + animalBoxValue);
    }

    static void writeBox(Box<? super Animal> box) {
        box.setValue(new Dog("멍멍이",100));
    }
}
