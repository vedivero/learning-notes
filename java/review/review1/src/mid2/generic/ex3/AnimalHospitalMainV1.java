package mid2.generic.ex3;

import mid2.generic.animal.Animal;
import mid2.generic.animal.Cat;
import mid2.generic.animal.Dog;

public class AnimalHospitalMainV1 {
    public static void main(String[] args) {

        AnimalHospitalV1 dogHospital = new AnimalHospitalV1();
        AnimalHospitalV1 catHospital = new AnimalHospitalV1();

        Dog dog = new Dog("멍멍이1", 200);
        Cat cat = new Cat("야옹이1", 30);

        dogHospital.setAnimal(dog);
        dogHospital.checkup();

        catHospital.setAnimal(cat);
        catHospital.checkup();

        dogHospital.setAnimal(cat);
        dogHospital.setAnimal(dog);

        Dog biggerDog = (Dog) dogHospital.getBigger(new Dog("멍멍이2", 300));
        System.out.println("biggerDog = " + biggerDog);
    }
}
