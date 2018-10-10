import java.util.Scanner;



public final class Solution {
    private Solution() {

    }

    public static void main(final String[] args) {
        LinkedList ll = new LinkedList();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
            case "insertAt":
                if (Integer.parseInt(tokens[1]) < 0 || Integer.parseInt(
                            tokens[1]) > ll.size() + 1) {
                    System.out.println("Can't insert at this position.");
                } else {
                    ll.insertAt(Integer.parseInt(tokens[1]),
                                Integer.parseInt(tokens[2]));
                    System.out.println(ll.displayAll());
                }
                break;
            case "reverse":
                if (!ll.isEmpty()) {
                    ll.reverse();
                    System.out.println(ll.displayAll());
                } else {
                    System.out.println("No elements to reverse.");
                }
                break;
            default:
                break;
            }
        }
    }
}

class LinkedList {
    private Node head;
    private Node tail;
    private int size = 0;
    private static int index = 0;
    private class Node {
        private int value;
        private Node next;
    }

    LinkedList() {
        head = null;
        tail = null;
    }

    public void deleteFront() {
        if (head != null) {
            head = head.next;
            size--;
        }
    }

    public void deleteBack() {
        if (tail != null) {
            Node temp = null;
            Node popped = tail;
            Node element = head;
            while (element != tail) {
                temp = element;
                element = element.next;
            }
            tail = temp;
            tail.next = null;
            // popped.next = null;
            size--;
            // return item;
        }
    }

    public void insertBack(final int value) {
        if (tail == null) {
            tail = new Node();
            tail.value = value;
            tail.next = null;
            head = tail;
        } else {
            Node oldTail = tail;
            tail = new Node();
            tail.value = value;
            tail.next = null;
            oldTail.next = tail;
        }
        size++;
    }

    public void insertFront(final int value) {
        if (head == null) {
            head = new Node();
            head.value = value;
            head.next = null;
            tail = head;
        } else {
            Node oldHead = head;
            head = new Node();
            head.value = value;
            head.next = oldHead;
        }
        size++;
    }
    public void insertAt(int pos, int value) {
        insertAt(head, pos, value);
    }
    public void insertAt(Node head, int pos, int value) {
        if (pos == 0) {
            insertFront(value);
            return;
        }
        if (index + 1 == pos) {
            Node new_node = new Node();
            // Node temp = head;
            new_node.value = value;
            new_node.next = head.next;
            head.next = new_node;
            index = 0;
            return;
        }
        index++;
        insertAt(head.next, pos, value);
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void reverse() {
        head = reverseRecursive(head);
    }
    private Node reverseRecursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
    public int size() {
        return size;
    }
    public String displayAll() {
        if (size != 0) {
            String str = "";
            Node temp = head;
            while (temp != null) {
                str += temp.value + ", ";
                temp = temp.next;
            }
            return str.substring(0, str.length() - 2);
        }
        return "";
    }
}
