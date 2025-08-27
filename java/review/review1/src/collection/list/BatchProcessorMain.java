package collection.list;

public class BatchProcessorMain {

    public static void main(String[] args) {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();

        BatchProcessor processor = new BatchProcessor(linkedList);
        processor.logic(50_000);
    }
}
