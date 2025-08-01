package collection.array;
import java.util.Arrays;

// 제네릭으로 처리
public class MyArrayListV4<E> {
    private static final int DEFAULT_CAPACITY = 5;
    private Object[] elementData;
    private int size = 0;
    public MyArrayListV4() {
        elementData = new Object[DEFAULT_CAPACITY];
    }
    public MyArrayListV4(int initialCapacity) {
        elementData = new Object[initialCapacity];
    }
    public int size() {
        return size;
    }
    public void add(E element) {

        if (size == elementData.length) {
            grow();
        }

        elementData[size] = element;
        size++;
    }

    public void add(int index, E e) {
        if (size == elementData.length) {
            grow();
        }

        shiftRightFrom(index);
        elementData[index] = e;
        size++;
    }

    //요소의 마지막부터 index까지 오른쪽으로 한 칸씩 이동
    private void shiftRightFrom(int index) {
        for (int i = 0; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }

    }

    private void grow() {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity * 2;

        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) elementData[index];
    }

    public E set(int index, E element) {
        E oldValue = get(index);
        elementData[index] = element;
        return oldValue;
    }


    public E remove(int index) {
        E oldValue = get(index);
        shiftLeftFrom(index);
        size--;
        elementData[size] = null;
        return oldValue;
    }

    private void shiftLeftFrom(int index) {
        for (int i = 0; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
    }

    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elementData, size)) + " size =" +
                size + ", capacity =" + elementData.length;
    }
}