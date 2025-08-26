package collection.link;

public class MyLinkedListV2 {

    private Node node;
    private int size = 0;

    public void add(Object e) {
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

    public void add(int index, Object object) {
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

    public Object set(int index, Object element) {
        Node x = getNode(index);
        Object oldValue = x.item;
        x.item = element;
        return oldValue;
    }

    public Object remove(int index) {
        Node removeNode = getNode(index);
        Object removeItem = removeNode.item;

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

    public Object get(int index) {
        Node node = getNode(index);
        return node.item;
    }

    private Node getNode(int index) {
        Node x = node;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    public int indexOf(Object object) {
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
}
