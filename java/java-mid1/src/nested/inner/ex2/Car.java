package nested.inner.ex2;

import nested.inner.ex1.Engine;

public class Car {
    private String model;
    private int chargeLevel;
    private Engine engine;

    public Car(String model, int chargeLevel) {
        this.model = model;
        this.chargeLevel = chargeLevel;
        this.engine = new Engine();
    }

    //아래 두 메서드도 이제 필요하지 않은 메서드

    //Engine에서만 사용하는 메서드
    //public String getModel() {
    //    return model;
    //}

    //Engine에서만 사용하는 메서드
    //public int getChargeLevel() {
    //    return chargeLevel;
    //}

    public void start() {
        engine.start();
        System.out.println(model + " 시작 완료");
    }

    public class Engine {

        // 내부에 선언되었으므로 외부 클래스 접근 가능 = 선언 불필요
        //private Car car;
        //public Engine(Car car) {
        //    this.car = car;
        //}

        //내부 클래스는 외부 클래스 인스턴스에 접근할 수 있음
        public void start() {
            //System.out.println("충전 레벨 확인 : " + getChargeLevel());
            //System.out.println(getModel()+"의 엔진을 구동합니다.");
            
            //바로 멤버 변수로 접근하면 됨
            System.out.println("충전 레벨 확인 : " + chargeLevel);
            System.out.println(model+"의 엔진을 구동합니다.");
        }

    }

}
