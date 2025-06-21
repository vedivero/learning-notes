package extends1.access.child;

import extends1.access.parent.Parent;

public class Child extends Parent {

    public void call() {
        publicValue = 1;
        protectedValue = 1; // 패키지가 다르지만 상속관계이기 때문에 호출 가능
        //defaultValue = 1; // 패키지가 달라서 호출 불가
        //privateValue = 1; // 접근 불가, 컴파일 오류

        publicMethod();
        protectedMethod();  // 상속관계이기 때문에 가능
        //defaultMethod();
        //privateMethod();

        printParent();
    }
}
