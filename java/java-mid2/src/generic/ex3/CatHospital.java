package generic.ex3;

import generic.animal.Cat;

public class CatHospital {

    private Cat animal;

    public void setCat(Cat animal) {
        this.animal = animal;
    }

    public void checkup() {
        System.out.println("동묾 이름 : " + animal.getName());
        System.out.println("동묾 크기 : " + animal.getSize());
        animal.sound();
    }

    public Cat bigger(Cat target) {
        return animal.getSize() > target.getSize() ? animal : target;
    }
}
