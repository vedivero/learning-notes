package lang.string.builder;

public class StringBuilderMain1_1 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("A");
        stringBuilder.append("B");
        stringBuilder.append("C");
        stringBuilder.append("D");

        System.out.println("stringBuilder = " + stringBuilder);

        stringBuilder.insert(4, "Java");
        System.out.println("insert = " + stringBuilder);

        stringBuilder.delete(4, 8);
        System.out.println("delete = "+ stringBuilder);

        stringBuilder.reverse();
        System.out.println("reverser = " + stringBuilder);

        String string = stringBuilder.toString();
        System.out.println("string = " + string);
    }
}
