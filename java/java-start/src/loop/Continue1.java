package loop;

public class Continue1 {
    public static void main(String[] args) {
        int i = 0;

        while (i <= 5) {
            if (i == 3) {
                i++;
                continue;
            }
            System.out.println("i = " + i);
            i++;
        }
    }
}
