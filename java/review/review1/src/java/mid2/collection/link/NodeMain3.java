package java.mid2.collection.link;

public class NodeMain3 {

    public static void main(String[] args) {
        Node first = new Node("A");
        first.next = new Node("B");
        first.next.next = new Node("C");

        System.out.println("모든 Node 탐색");
        System.out.println("first = " + first);

        System.out.println(" ");
        System.out.println("마지막 노드 조회");
        Node lastNode = getLastNode(first);
        System.out.println("lastNode = " + lastNode);

        System.out.println(" ");
        System.out.println("특정 index의 노드 조회");
        int index = 2;
        Node indexNode = getNode(first, index);
        System.out.println("indexNode = " + indexNode.item);

        System.out.println(" ");
        System.out.println("데이터 추가");
        add(first, "D");
        add(first, "E");
        add(first, "F");
        System.out.println("first = " + first);

        System.out.println(" ");
        printAll(first);

    }

    private static void printAll(Node node) {
        Node x = node;
        while (x.next != null) {
            System.out.println("x = " + x.item);
            x = x.next;
        }
    }

    private static void add(Node node, Object param) {
        Node lastNode = getLastNode(node);
        lastNode.next = new Node(param);
    }

    private static Node getNode(Node node, int index) {
        Node x = node;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    private static Node getLastNode(Node node) {
        Node x = node;
        while (x.next != null) {
            x = x.next;
        }
        return x;
    }

}
