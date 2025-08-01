package collection.list;

public class BetchProcessor {

    private final MyList<Integer> list;

    public BetchProcessor(MyList<Integer> list) {
        this.list = list;
    }

    public void login(int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(0, i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("크기 = " + size + ", 계산 시간 : " + (endTime - startTime) + "ms");
    }
}
