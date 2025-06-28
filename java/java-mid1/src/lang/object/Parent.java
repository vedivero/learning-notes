package lang.object;

// 자바 클래스는 항상 최상위 클래스인 Object클래스를 상속받는다(묵시적)
public class Parent extends Object{
    public void parentMethod() {
        System.out.println("Parent.parentMethod");
    }
}
