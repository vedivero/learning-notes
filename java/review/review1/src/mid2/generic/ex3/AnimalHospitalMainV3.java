package mid2.generic.ex3;

import mid2.generic.animal.Cat;
import mid2.generic.animal.Dog;

public class AnimalHospitalMainV3 {
    public static void main(String[] args) {

        AnimalHospitalV3<Dog> dogHospital = new AnimalHospitalV3<>();
        AnimalHospitalV3<Cat> catHospital = new AnimalHospitalV3<>();

        Dog dog = new Dog("멍멍이1", 100);
        Cat cat = new Cat("야옹이1", 50);

        dogHospital.setAnimal(dog);
        dogHospital.checkup();

        catHospital.setAnimal(cat);
        catHospital.checkup();

        //dogHospital.setAnimal(cat);
        Dog biggerDog = (Dog) dogHospital.getBigger(new Dog("멈멍이2", 400));
        System.out.println("biggerDog = " + biggerDog);
    }
}
