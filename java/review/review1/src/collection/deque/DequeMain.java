package collection.deque;

import java.util.ArrayDeque;

public class DequeMain {

    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        deque.offerFirst(1);
        System.out.println(" ");
        System.out.println("deque = " + deque);

        deque.offerFirst(2);
        System.out.println(" ");
        System.out.println("deque = " + deque);

        deque.offerLast(3);
        System.out.println(" ");
        System.out.println("deque = " + deque);

        deque.offerLast(4);
        System.out.println(" ");
        System.out.println("deque = " + deque);

        System.out.println(" ");
        System.out.println("deque.peekFirst() = " + deque.peekFirst());
        System.out.println("deque.peekLast() = " + deque.peekLast());

        System.out.println(" ");
        System.out.println("deque.pollFirst() = " + deque.pollFirst());
        System.out.println("deque.pollFirst() = " + deque.pollFirst());
        System.out.println("deque.pollLast() = " + deque.pollLast());
        System.out.println("deque.pollLast() = " + deque.pollLast());
    }
}
