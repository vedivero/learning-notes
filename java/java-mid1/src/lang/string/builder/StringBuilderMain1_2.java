package lang.string.builder;

public class StringBuilderMain1_2 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

        String string = stringBuilder.append("A").append("B").append("C").append("D")
                .insert(4, "Java")
                .delete(4, 8)
                .reverse()
                .toString();

        System.out.println("stringBuilder = " + stringBuilder);
        System.out.println("insert = " + stringBuilder);
        System.out.println("delete = "+ stringBuilder);
        System.out.println("reverser = " + stringBuilder);
        System.out.println("string = " + string);
    }
}
