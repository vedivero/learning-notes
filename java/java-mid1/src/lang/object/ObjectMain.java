package lang.object;

public class ObjectMain {
    public static void main(String[] args) {
        Child child = new Child();
        child.childMethod();
        child.parentMethod();

        //toString = Objct Class의 메서드
        //객체에 대한 정보를 반환하는 메서드
        String string = child.toString();
        System.out.println(string);
    }
}
