package extends1.super2;

public class ClassC extends ClassB {
    public ClassC() {
        //super();    // ClassB에서 생성자를 정의했기 때문에 여기서는 생성자 생성 불가
        super(10,20);
        System.out.println("ClassC 생성자");
    }
}
