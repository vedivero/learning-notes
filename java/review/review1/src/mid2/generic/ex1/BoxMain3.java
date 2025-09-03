package mid2.generic.ex1;

public class BoxMain3 {
    public static void main(String[] args) {
        GenericBox<Integer> integerBox = new GenericBox<Integer>();
        integerBox.setValue(10);
        Integer integer = (Integer) integerBox.getValue();
        System.out.println("integer = " + integer);

        System.out.println(" ");
        GenericBox<String> stringBox = new GenericBox<String>();
        stringBox.setValue("hello");
        String str = (String) stringBox.getValue();
        System.out.println("str = " + str);

        System.out.println(" ");
        GenericBox<Double> doubleBox = new GenericBox<Double>();
        doubleBox.setValue(10.5);
        Double doubleValue = (Double) doubleBox.getValue();
        System.out.println("doubleValue = " + doubleValue);

        GenericBox<Integer> integerGenericBox = new GenericBox<>();
    }
}
