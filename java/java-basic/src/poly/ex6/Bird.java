package poly.ex6;

public class Bird extends AbstractAnimal implements Fly {
    @Override
    public void fly() {
        System.out.println("새가 날아갑니다.");
    }

    @Override
    public void sound() {
        System.out.println("짹짹");
    }
}
