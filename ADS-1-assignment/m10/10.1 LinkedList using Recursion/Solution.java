import java.util.Scanner;


/**
 * Solution Class.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * Main Function.
     *
     * @param      args  The arguments
     */
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
/**
 * List of linkeds.
 */
class LinkedList {
    /**
     * Node head.
     */
    private Node head;
    /**
     * Node tail.
     */
    private Node tail;
    /**
     * Int size.
     */
    private int size = 0;
    /**
     * int index.
     */
    private static int index = 0;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * Int value.
         */
        private int value;
        /**
         * Int next.
         */
        private Node next;
    }
    /**
     * Constructs the object.
     */
    LinkedList() {
        head = null;
        tail = null;
    }
    /**
     * Delete List Front.
     */
    public void deleteFront() {
        if (head != null) {
            head = head.next;
            size--;
        }
    }
    /**
     * Delete List Back.
     */
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
    /**
     * Insert List Back.
     *
     * @param      value  The value
     */
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
    /**
     * Insert List Front.
     *
     * @param      value  The value
     */
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
    /**
     * Insert Function.
     *
     * @param      pos    The position
     * @param      value  The value
     */
    public void insertAt(final int pos, final int value) {
        insertAt(head, pos, value);
    }
    /**
     * Insert Function Overridding.
     *
     * @param      head1   The head
     * @param      pos    The position
     * @param      value  The value
     */
    public void insertAt(final Node head1, final int pos, final int value) {
        if (pos == 0) {
            insertFront(value);
            return;
        }
        if (index + 1 == pos) {
            Node newNode = new Node();
            // Node temp = head1;
            newNode.value = value;
            newNode.next = head1.next;
            head1.next = newNode;
            index = 0;
            return;
        }
        index++;
        insertAt(head1.next, pos, value);
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return head == null;
    }
    /**
     * Reversers the list.
     */
    public void reverse() {
        head = reverseRecursive(head);
    }
    /**
     * Helper for Reverse.
     *
     * @param      head  The head
     *
     * @return     { description_of_the_return_value }
     */
    private Node reverseRecursive(final Node head1) {
        if (head1 == null || head1.next == null) {
            return head1;
        }
        Node temp = reverseRecursive(head1.next);
        head1.next.next = head;
        head1.next = null;
        return temp;
    }
    /**
     * Returns the size.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size;
    }
    /**
     * Displays the Linked List.
     *
     * @return     { description_of_the_return_value }
     */
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
