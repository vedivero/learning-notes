package collection.list;

public class MyListPerformanceTest {

    public static void main(String[] args) {

        int size = 20_000;

        System.out.println(" ");
        System.out.println("===== MyArrayList 추가 =====");
        addFirst(new MyArrayList<>(),size);
        addMid(new MyArrayList<>(),size);

        MyArrayList<Integer> arrayList = new MyArrayList<>();
        addLast(arrayList,size);
        System.out.println(" ");

        int loop = 10_000;
        System.out.println("===== MyArrayList 조회 =====");
        getIndex(arrayList, loop, 0);
        getIndex(arrayList, loop, size / 2);
        getIndex(arrayList, loop, size - 1);
        System.out.println(" ");

        System.out.println("===== MyArrayList 검색 =====");
        searchIndex(arrayList, loop, 0);
        searchIndex(arrayList, loop, size / 2);
        searchIndex(arrayList, loop, size - 1);
        System.out.println(" ");





        System.out.println("===== MyLinkedList 추가 =====");
        addFirst(new MyLinkedList<>(),size);
        addMid(new MyLinkedList<>(), size);


        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        addLast(linkedList, size);
        System.out.println(" ");

        System.out.println("===== MyLinkedList 조회 =====");
        getIndex(linkedList, loop, 0);
        getIndex(linkedList, loop, size / 2);
        getIndex(linkedList, loop, size - 1);
        System.out.println(" ");

        System.out.println("===== MyLinkedList 검색 =====");
        searchIndex(linkedList, loop, 0);
        searchIndex(linkedList, loop, size / 2);
        searchIndex(linkedList, loop, size - 1);

        System.out.println(" ");

    }

    private static void addFirst(MyList<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(0, i);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("0번 index 추가 : 실행 시간 = " + (endTime - startTime) + "ms");
    }

    private static void addMid(MyList<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(i / 2, i);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("중간 index 추가 : 실행 시간 = " + (endTime - startTime) + "ms");
    }

    private static void addLast(MyList<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(0, i);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("마지막 index 추가 : 실행 시간 = " + (endTime - startTime) + "ms");
    }

    private static void getIndex(MyList<Integer> list, int loop, int index) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            list.get(index);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("index : " + index + ", loop : " + loop + ", time : " + (endTime - startTime) + "ms");
    }

    private static void searchIndex(MyList<Integer> list, int loop, int findValue) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            list.indexOf(findValue);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("findValue: " + findValue + ", 반복: " + loop + ", 계산 시간: " + (endTime - startTime) + "ms");
    }

}
