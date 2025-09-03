package mid2.collection.map.test.stack;

import java.util.ArrayDeque;

public class SimpleHistoryTest {
    public static void main(String[] args) {
        ArrayDeque<Object> stack = new ArrayDeque<>();
        stack.push("youtube.com");
        System.out.println("stack = " + stack);
        stack.push("google.com");
        System.out.println("stack = " + stack);
        stack.push("facebook.com");
        System.out.println("stack = " + stack);

        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
    }
}
