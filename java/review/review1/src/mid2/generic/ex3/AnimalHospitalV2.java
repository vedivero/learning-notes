package mid2.generic.ex3;

import mid2.generic.animal.Animal;

public class AnimalHospitalV2<T> {

    private T animal;

    public void setAnimal(T animal) {
        this.animal = animal;
    }

    public void checkup() {
        //System.out.println("동물 이름 : " + animal.getName());
        //System.out.println("동물 크기 : " + animal.getSize());
        //animal.sound();

        animal.toString();
        animal.equals(null);
    }

    public Animal getBigger(Animal targer) {
        //return animal.getSize() > targer.getSize() ? animal : targer;
        return null;
    }
}
