package generic.ex3;

import generic.animal.Animal;
import generic.animal.Dog;

public class AnimalHospitalV1 {

    private Animal animal;

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public void checkup() {
        System.out.println("동묾 이름 : " + animal.getName());
        System.out.println("동묾 크기 : " + animal.getSize());
        animal.sound();
    }

    public Animal getBigger(Dog target) {
        return animal.getSize() > target.getSize() ? animal : target;
    }

}
