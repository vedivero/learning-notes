package generic.ex3;

import generic.animal.Dog;

public class AnimalHospitalV2<T> {

    private T animal;

    public void setAnimal(T animal) {
        this.animal = animal;
    }

    public void checkup() {
        // T의 타입은 메서드를 정의하는 시점에는 알 수 없음 -> Object의  기능만 사용
        // System.out.println("동묾 이름 : " + animal.getName());
        // System.out.println("동묾 크기 : " + animal.getSize());
        // animal.sound();

    }

    public T getBigger(Dog target) {
        // T의 타입은 메서드를 정의하는 시점에는 알 수 없음 -> Object의  기능만 사용
        // return animal.getSize() > target.getSize() ? animal : target;
        return null;
    }

}
