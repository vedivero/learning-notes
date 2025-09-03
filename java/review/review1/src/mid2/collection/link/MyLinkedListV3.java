package mid2.collection.link;

public class MyLinkedListV3<E> {

    private Node<E> node;
    private int size = 0;

    public void add(E e) {
        Node newNode = new Node(e);
        if (node == null) {
            node = newNode;
        }
        else {
            Node lastNode = getLastNode();
            lastNode.next = newNode;
        }
        size++;
    }

    public void add(int index, E object) {
        Node newNode = new Node(object);

        if (index == 0) {
            newNode.next = node;
            node = newNode;
        }else{
            Node prev = getNode(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }

    private Node getLastNode() {
        Node x = node;
        while (x.next != null) {
            x = x.next;
        }
        return x;
    }

    public E set(int index, E element) {
        Node x = getNode(index);
        E oldValue = (E) x.item;
        x.item = element;
        return oldValue;
    }

    public E remove(int index) {
        Node removeNode = getNode(index);
        E removeItem = (E) removeNode.item;

        if (index == 0) {
            node = removeNode.next;
        }else{
            Node prev = getNode(index - 1);
            prev.next = removeNode.next;
        }
        removeNode.item = null;
        removeNode.next = null;
        size--;
        return removeItem;
    }

    public E get(int index) {
        Node node = getNode(index);
        return (E) node.item;
    }

    private Node getNode(int index) {
        Node x = node;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    public int indexOf(E object) {
        int index = 0;
        for (Node x = node; x != null; x = x.next) {
            if (object.equals(x.item)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "MyLinkedListV1{" +
                "node=" + node +
                ", size=" + size +
                '}';
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item) {
            this.item = item;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node<E> temp = this;
            sb.append("[");
            while (temp != null) {
                sb.append(temp.item);
                if (temp.next != null) {
                    sb.append("->");
                }
                temp
                        = temp.next;
            }
            sb.append("]");
            return sb.toString();
        }
    }
}
