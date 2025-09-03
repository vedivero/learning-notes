package mid2.collection.deque;

import java.util.ArrayDeque;

public class DequeQueueMain {

    public static void main(String[] args) {

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        deque.offer(1);
        deque.offer(2);
        deque.offer(3);
        System.out.println("deque = " + deque);

        System.out.println(" ");
        System.out.println("deque.peek() = " + deque.peek());

        System.out.println(" ");
        System.out.println("deque.poll() = " + deque.poll());
        System.out.println("deque.poll() = " + deque.poll());
        System.out.println("deque.poll() = " + deque.poll());
        System.out.println("deque = " + deque);

    }
}
