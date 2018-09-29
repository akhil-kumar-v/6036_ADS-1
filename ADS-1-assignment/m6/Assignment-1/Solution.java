import java.util.Scanner;


class Node {
    Node link;
    int value;
    Node() {
        link = null;
        value = 0;
    }
    Node(Node givenLink, int data) {
        link = givenLink;
        value = data;

    }
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
    // int size;
    int top;

    LinkedList() {
        head = null;
        tail = null;
        // size = 0;
        top = -1;
    }

    void listPush(int value) {
        Node newNode = new Node(null, value);
        top++;
        if (head == null) {
            head = newNode;
            tail = head;
            // head.setLink(newNode);
        } else {
            tail.setLink(newNode);
        }
    }
    int listPop() {
        // if (head == null) {

        // } else if (top == 1) {
        //     head = head.getLink();
        // }


        //=========================

        Node st = head;
        Node ta = head;
        while (st != tail) {
            ta = st;
            st = st.getLink();
        }
        int val = ta.getData();
        tail = ta;
        tail.setLink(null);
        top --;
        return val;
        //=========================
    }

    int getSize() {
        return top + 1;
    }

    boolean isEmpty() {
        return top == -1;
    }

}
class AddLargeNumbers {
    static Node head;
    static Node tail;

    public static LinkedList numberToDigits(String number) {
        String[] list = number.split(" ");
        LinkedList li = new LinkedList();
        for (int i = 0; i < list.length; i++) {
            li.listPush(Integer.parseInt(list[i]));
        }
        // System.out.println("sss = " + digitsToNumber(li));
        return li;
    }

    public static String digitsToNumber(LinkedList list) {
        Node st = list.head;
        Node ta = list.head;
        String str = "";
        // System.out.println("helloooooo");
        // System.out.println("st " + st);
        while (st != tail) {
            ta = st;
            // System.out.println("data = " + st.getData());
            // System.out.println("link = " + st.getLink());
            str = "" + st.getData();
            st = st.getLink();
        }
        // System.out.println("str = |" + str + "|");
        return str;
    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        int size1 = list1.getSize();
        LinkedList ans = new LinkedList();

        return list1;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch (input) {
        case "numberToDigits":
            LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
            LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
            System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
            System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
            break;

        case "addLargeNumbers":
            pDigits = AddLargeNumbers.numberToDigits(p);
            qDigits = AddLargeNumbers.numberToDigits(q);
            LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
            System.out.println(AddLargeNumbers.digitsToNumber(result));
            break;
        }
    }

}
