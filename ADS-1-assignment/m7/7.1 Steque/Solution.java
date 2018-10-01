import java.util.Scanner;

/**
 * Class for node.
 */

class Node {
    /**
     * Int data.
     */
    private int data;
    /**
     * Node link.
     */
    private Node linkF;
    /**
     * Node Constructer.
     *
     * @param      dataNew   The data new
     * @param      linkNew1  The link new 1
     */
    Node(final int dataNew, final Node linkNew1) {
        data = dataNew;
        linkF = linkNew1;
        // linkR = linkNew2;
    }
    /**
     * Sets the data.
     *
     * @param      d     { parameter_description }
     */
    void setData(final int d) {
        data = d;
    }
    /**
     * Sets the link.
     *
     * @param      link1  The link 1
     */
    void setLink(final Node link1) {
        linkF = link1;
        // linkR = link2;
    }
    /**
     * Gets the data.
     *
     * @return     The data.
     */
    int getData() {
        return data;
    }
    /**
     * Gets the link.
     *
     * @return     The link.
     */
    Node getLink() {
        return linkF;
    }

    // Node getLinkR() {
    //     return linkR;
    // }
}
/**
 * Class for linked.
 */
class Linked {
    /**
     * Node head.
     */
    private Node head;
    /**
     * Node Tail.
     */
    private Node tail;
    /**
     * Int size.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Linked() {
        head = null;
        tail = null;
        size = -1;
    }
    /**
     * enqueue.
     *
     * @param      data  The data
     */
    void enqueue(final int data) {
        // System.out.println("-----------------------");
        Node ptr = new Node(data,  null);
        // System.out.println("ptr created now"+ptr);
        if (head == null) {
            // System.out.println(" i ");
            head = ptr;
            tail = head;
            size++;
        } else {
            // System.out.println("old tail link " + tail);
            tail.setLink(ptr);
            tail = ptr;
            size++;

        }
        printLinked();
    }
    /**
     * Pops from list.
     */
    void pop() {
        if (size <= 0) {
            System.out.println("Steque is empty.");
            head = null;
            tail = head;
        } else {
            try {
                Node rev = head.getLink();
                head = rev;
                size--;
                // rev.setLink(null);
                printLinked();
            } catch (Exception e) {

            }
        }
        // printLinked();

    }
    /**
     * Push into List.
     *
     * @param      data  The data
     */
    void push(final int data) {
        Node ptr = new Node(data, null);

        if (head == null) {
            head = ptr;
            tail = ptr;
            size++;
        } else {
            // Node ne = head;
            // head.setLink(null,ne)
            size++;
            ptr.setLink(head);
            head = ptr;
        }
        printLinked();
    }
    /**
     * Prints List.
     */
    void printLinked() {
        Node ptr = head;
        Node temp = ptr;

        System.out.print(head.getData());
        // System.out.println("hello");
        try {
            // System.out.print(head.getData()+"s");
            // ptr = head.getLink();

            while (ptr != null && head.getLink() != null)  {
                // System.out.println("ss");
                // System.out.print(head.getData() + ", ");
                // if (ptr == head)
                // System.out.print(head.getData() );

                temp = ptr;
                ptr = ptr.getLink();
                System.out.print(", " + ptr.getData());
                // System.out.println("ptr = " + ptr);

            }
            // System.out.print(temp.getData() + "\n");
        } catch (Exception e) {

        }
        // System.out.println();
        System.out.println();

    }
}
/**
 * Class Solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * Main Funtion.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        String str = "";
        // String[] line = sc.nextLine().split(" ");
        // while (t > 0) {

        //     String str = sc.nextLine();
        //     while (str.length() > 0) {
        //         // System.out.println("next");
        //         String[] line = str.split(" ");
        //         try {
        //             str = sc.nextLine();

        //         } catch (Exception e) {
        //             t--;
        //             break;
        //         }
        //         switch (line[0]) {
        //         case "push":
        //             li.push(Integer.parseInt(line[1]));
        //             break;
        //         case "pop":
        //             li.pop();
        //             break;
        //         case "enqueue":
        //             li.enqueue(Integer.parseInt(line[1]));
        //             break;
        //         }
        //     }

        // }
        while (t > 0) {
            // System.out.println("sdsds");
            Linked li = new Linked();
            try {
                while ((str = sc.nextLine()) != null) {
                    // System.out.println("test");
                    if (str.length() == 0) {
                        break;
                    }
                    String[] line = str.split(" ");
                    switch (line[0]) {
                    case "push":
                        li.push(Integer.parseInt(line[1]));
                        break;
                    case "pop":
                        li.pop();
                        break;
                    case "enqueue":
                        li.enqueue(Integer.parseInt(line[1]));
                        break;
                    default:

                    }
                }
                t--;
                System.out.println();
            } catch (Exception r) {
                // t--;
                break;
            }

        }

    }
}
