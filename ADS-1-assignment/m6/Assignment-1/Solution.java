/*
 * Java Program to Implement Stack using Linked List
 */

import java.util.*;

import java.lang.StringBuilder;


/*  Class Node  */
class Node {
    protected int data;
    protected Node link;

    /*  Constructor  */
    public Node() {
        link = null;
        data = 0;
    }
    /*  Constructor  */
    public Node(int d, Node n) {
        data = d;
        link = n;
    }
    /*  Function to set link to next Node  */
    public void setLink(Node n) {
        link = n;
    }
    /*  Function to set data to current Node  */
    public void setData(int d) {
        data = d;
    }
    /*  Function to get link to next node  */
    public Node getLink() {
        return link;
    }
    /*  Function to get data from current Node  */
    public int getData() {
        return data;
    }
}

/*  Class linkedStack  */
class LinkedListStack {
    protected Node top ;
    protected int size ;

    /*  Constructor  */
    public LinkedListStack() {
        top = null;
        size = 0;
    }
    /*  Function to check if stack is empty */
    public boolean isEmpty() {
        return top == null;
    }
    /*  Function to get the size of the stack */
    public int getSize() {
        return size;
    }
    /*  Function to push an element to the stack */
    public void listPush(int data) {
        Node nptr = new Node (data, null);
        if (top == null)
            top = nptr;
        else {
            nptr.setLink(top);
            top = nptr;
        }
        size++ ;
    }
    /*  Function to pop an element from the stack */
    public int listPop() {
        Node ptr = top;
        top = ptr.getLink();
        size-- ;
        return ptr.getData();
    }
    /*  Function to display the status of the stack */
    public String display() {
        // System.out.print("\nStack = ");
        String str = "";
        // if (size == 0) {
        //     System.out.print("Empty\n");
        //     return ;
        // }
        Node ptr = top;
        while (ptr != null) {
            // System.out.print(ptr.getData() + " ");
            str += "" + ptr.getData();
            ptr = ptr.getLink();
        }
        // System.out.println();
        return str;
    }
}

class AddLargeNumbers {

    public static LinkedListStack numberToDigits(String number) {
        LinkedListStack li = new LinkedListStack();
        String[] list = number.split("");
        for (int i = 0; i < list.length; i++) {
            li.listPush(Integer.parseInt(list[i]));
        }
        return li;
    }

    public static String digitsToNumber(LinkedListStack list) {
        String str = "";
        // return str;
        str = list.display();
        StringBuilder st = new StringBuilder();
        st.append(str);
        str=""+st.reverse();
        return str;
    }

    public static LinkedListStack addLargeNumbers(LinkedListStack list1, LinkedListStack list2) {
        LinkedListStack ans = new LinkedListStack();
        return ans;
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
            LinkedListStack pDigits = AddLargeNumbers.numberToDigits(p);
            LinkedListStack qDigits = AddLargeNumbers.numberToDigits(q);
            System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
            System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
            break;

        case "addLargeNumbers":
            pDigits = AddLargeNumbers.numberToDigits(p);
            qDigits = AddLargeNumbers.numberToDigits(q);
            LinkedListStack result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
            System.out.println(AddLargeNumbers.digitsToNumber(result));
            break;
        }
    }

}
