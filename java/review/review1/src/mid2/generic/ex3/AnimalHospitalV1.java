package mid2.generic.ex3;

import mid2.generic.animal.Animal;

public class AnimalHospitalV1 {

    private Animal animal;

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public void checkup() {
        System.out.println("동물 이름 : " + animal.getName());
        System.out.println("동물 크기 : " + animal.getSize());
        animal.sound();
    }

    public Animal getBigger(Animal targer) {
        return animal.getSize() > targer.getSize() ? animal : targer;
    }
}
