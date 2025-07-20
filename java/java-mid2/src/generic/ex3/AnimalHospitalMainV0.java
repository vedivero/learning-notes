package generic.ex3;

import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalHospitalMainV0 {
    public static void main(String[] args) {

        DogHospital dogHospital = new DogHospital();
        CatHospital catHospital = new CatHospital();

        Dog dog = new Dog("멍멍이1", 100);
        Cat cat = new Cat("야옹이1", 100);

        dogHospital.setDog(dog);
        dogHospital.checkup();

        catHospital.setCat(cat);
        catHospital.checkup();

        //문제1 : 개 병원 <- 고양이 방문
        //dogHospital.setDog(cat); // 다른 타입 입력 -> 컴파일 오류

        //문제2 : 개 타입 반환
        dogHospital.setDog(dog);
        Dog biggerDog = dogHospital.bigger(new Dog("멍멍이2", 200));

    }
}
