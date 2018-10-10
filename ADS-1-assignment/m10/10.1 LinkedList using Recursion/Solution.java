import java.util.Scanner;

class InvalidPositionException extends Exception {
    public String toString() {
        return "Can't insert at this position.";
    }
}
class NoElementException extends Exception {
    public String toString() {
        return "No elements to reverse.";
    }
}
class Node {
    Node link;
    int value;
    Node(int data) {
        link = null;
        value = data;
    }
    // Node(int data, Node givenLink) {
    //     link = givenLink;
    //     value = data;

    // }
    void setLink(Node l) {
        link = l;
    }
    void setData(int d) {
        value = d;
    }
    int getData() {
        return value;
    }
    Node getLink() {
        return link;
    }
}
class LinkedList {
    Node head;
    Node tail;
    int size;
    int count;
    // Node temp;

    // int top;

    LinkedList() {
        head = null;
        tail = null;
        size = 0;
        count = 0;
        // temp = head.link;

        // top = -1;
    }

    void insertAt(int pos, int data) {
        insertAtpos(head, pos, data);

    }
    void insertAtpos(Node head, int pos, int data) {
        if (pos == 0) {
            insertFront(count);
            return;
        }
        if (count + 1 == pos) {
            Node new_node = new Node(data);
            // Node temp = head;
            new_node.link = head.link;
            head.link = new_node;
            count = 0;
            return;
        }
        count++;
        insertAtpos(head.link, pos, data);

    }
    void insertFront(final int value) {
        if (head == null) {
            Node head = new Node(value);
            // head.value = valuvaluee;
            head.link = null;
            tail = head;
        } else {
            Node temp = new Node(value);
            // temp.value = value;
            temp.link = head;
            head = temp;
        }
        size++;
    }

    void printList() {
        Node node;
        node = head;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.link;
        }
        System.out.println();
    }
    void printList1(Node node) {
        // Node node;
        // node = head;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.link;
        }
        System.out.println();
    }
    Node reverse() {
        Node node;
        node = head;
        try {
            if (node.link == null) {
                throw new NoElementException();
            } else {
                //reverse the elements here
                Node prev = null;
                Node current = node;
                Node next = null;
                while (current != null) {
                    next = current.link;
                    current.link = prev;
                    prev = current;
                    current = next;
                }
                node = prev;
                System.out.println("aaa");
                System.out.println(node.value);
                printList1(node);

                return node;
            }
        } catch (Exception e) {
            // System.out.println(e.getMessage());
            System.out.println("No elements to reverse.");
            return node;
        }


    }

}
class Solution {
    Solution() {

    }
    public static void main(String[] args) {
        LinkedList li = new LinkedList();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // li.head = new Node(85);
            // li.head.link = new Node(15);
            // li.head.link.link = new Node(4);
            // li.head.link.link.link = new Node(20);
            String[] line = sc.nextLine().split(" ");
            switch (line[0]) {
            case "insertAt":
                if (Integer.parseInt(line[1]) < 0 || Integer.parseInt(
                            line[1]) > li.size + 1) {
                    System.out.println("Can't insert at this position.");
                } else {
                    li.insertAt(Integer.parseInt( line[1]), Integer.parseInt( line[2]));
                    li.printList();
                    //     System.out.println();
                }
                break;
            case "reverse":
                li.reverse();
                break;

            }
        }
    }
}
