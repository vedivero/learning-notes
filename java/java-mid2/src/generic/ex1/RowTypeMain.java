package generic.ex1;

public class RowTypeMain {
    public static void main(String[] args) {
        GenericBox integerBox = new GenericBox();
        integerBox.setValue(10);

        //String result = (String) integerBox.getValue();
        Integer result = (Integer) integerBox.getValue();
        System.out.println("result = " + result);
    }
}
