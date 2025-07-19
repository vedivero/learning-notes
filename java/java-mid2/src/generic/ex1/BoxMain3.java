package generic.ex1;

public class BoxMain3 {

    public static void main(String[] args) {

        // 생성 시점에 타입 결정
        GenericBox<Integer> integerBox = new GenericBox<Integer>();

        integerBox.setValue(10);
        //integerBox.setValue("hello"); // Compile Error
        Integer value1 = integerBox.getValue();

        System.out.println("value1 = " + value1);

        GenericBox<String> stringGenericBox = new GenericBox<>();
        stringGenericBox.setValue("hello");
        //stringGenericBox.setValue(99); // Compile Error
        String value = stringGenericBox.getValue();
        System.out.println("value = " + value);

        GenericBox<Double> doubleGenericBox = new GenericBox<Double>();
        doubleGenericBox.setValue(10.5);
        Double value2 = doubleGenericBox.getValue();
        System.out.println("value2 = " + value2);

        //타입 추론 : 생성하는 제네릭 타입 생략이 가능
        GenericBox<Integer> integerBox2 = new GenericBox<>();

    }
}
