package lang.object.poly;

public class ObjectPolyExample1 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Car car = new Car();



        action(dog);
        action(car);
    }

    private static void action(Object obj) {
        //obj.sound();  // 컴파일 오류 발생. Object Class에는 sound()메서드가 없음
        //obj.move();   // 컴파일 오류 발생. Object Class에는 move()메서드가 없음

        // 호출을 하려면, 다운캐스팅이 필요
        // 자바16부터 바로 변수 선언 가능
        if (obj instanceof Dog dog) {
            dog.sound();
        } else if (obj instanceof Car car) {
            car.move();
        }
    }
}
