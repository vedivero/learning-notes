package collection.list;

public class BetchProcessorMain {

    public static void main(String[] args) {
        //MyArrayList<Integer> list = new MyArrayList<>();
        MyLinkedList<Integer> list = new MyLinkedList<>();

        BetchProcessor processor = new BetchProcessor(list);
        processor.login(10_000_000);

    }
}
