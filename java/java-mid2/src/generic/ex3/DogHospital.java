package generic.ex3;

import generic.animal.Dog;

public class DogHospital {

    private Dog animal;

    public void setDog(Dog animal) {
        this.animal = animal;
    }

    public void checkup() {
        System.out.println("동묾 이름 : " + animal.getName());
        System.out.println("동묾 크기 : " + animal.getSize());
        animal.sound();
    }

    public Dog bigger(Dog target) {
        return animal.getSize() > target.getSize() ? animal : target;
    }
}
