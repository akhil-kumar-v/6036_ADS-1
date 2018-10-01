import java.util.Scanner;



class Node {
    int data;
    Node linkF;
    // Node linkR;
    Node(int dataNew, Node linkNew1) {
        data = dataNew;
        linkF = linkNew1;
        // linkR = linkNew2;
    }
    void setData(int d) {
        data = d;
    }

    void setLink(Node link1) {
        linkF = link1;
        // linkR = link2;
    }
    int getData() {
        return data;
    }
    Node getLink() {
        return linkF;
    }

    // Node getLinkR() {
    //     return linkR;
    // }
}

class Linked {
    Node head;
    Node tail;
    int size;
    Linked() {
        head = null;
        tail = null;
        size = -1;
    }

    void enqueue(int da) {
        // System.out.println("-----------------------");
        Node ptr = new Node(da,  null);
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
    void push(int da) {
        Node ptr = new Node(da, null);

        if (head == null) {
            head = ptr;
            tail = ptr;
            size++;
        } else {
            // Node ne = head;
            // head.setLink(null,ne)
            size++;
            ptr.setLink( head);
            head = ptr;
        }
        printLinked();
    }
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

                System.out.print(", " + ptr.getData() );
                // System.out.println("ptr = " + ptr);

            }
            // System.out.print(temp.getData() + "\n");
        } catch (Exception e) {

        }
        // System.out.println();
        System.out.println();

    }
}

final class Solution {
    private Solution() {

    }
    public static void main(String[] args) {
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
                while ((str = sc.nextLine() ) != null) {
                    // System.out.println("test");
                    if (str.length() == 0) break;
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
                    }
                }
                t--;
                System.out.println();
            } catch (Exception r){
                // t--;
                break;
            }

        }

    }
}
