package mid2.generic.ex3;

import mid2.generic.animal.Cat;
import mid2.generic.animal.Dog;

public class AnimalHospitalMainV0 {
    public static void main(String[] args) {

        DogHospital dogHospital = new DogHospital();

        Dog dog = new Dog("멍멍이", 50);

        dogHospital.setAnimal(dog);
        dogHospital.checkup();

        CatHospital catHospital = new CatHospital();

        Cat cat = new Cat("야옹이", 20);

        catHospital.setAnimal(cat);
        catHospital.checkup();

        dogHospital.setAnimal(dog);
        Dog biggerDog = dogHospital.getBigger(new Dog("멍멍이2", 200));
        System.out.println("biggerDog = " + biggerDog);
    }
}
