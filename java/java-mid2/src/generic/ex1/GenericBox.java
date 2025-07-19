package generic.ex1;

public class GenericBox<T> {
    //T가 타입 = 타입 매개 변수
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
