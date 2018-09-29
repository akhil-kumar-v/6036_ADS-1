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
        str = "" + st.reverse();
        return str;
    }

    public static LinkedListStack addLargeNumbers(LinkedListStack list1, LinkedListStack list2) {
        LinkedListStack ans = new LinkedListStack();
        int s1 = list1.getSize();
        int s2 = list2.getSize();
        // System.out.println("s1 =" + s1 + " s2 = " + s2);
        int sum = 0;
        int rem = 0;
        int temp = 0;
        // if (s1 >= s2) {
        // System.out.println("herer");
        Node ptr1 = list1.top;
        Node ptr2 = list2.top;
        while (ptr2 != null || ptr1 != null) {
            // System.out.println("here also ptr2 = " + ptr2);
            sum = ptr1.getData() + ptr2.getData();
            // System.out.println("////////////////sum =" + sum);
            if (sum < 9) {
                // System.out.println("<9");
                ans.listPush(sum);
                ptr1 = ptr1.getLink();
                ptr2 = ptr2.getLink();
            } else if (sum > 9) {
                if (sum % 10 == 0) {
                    rem = sum % 10;
                    ans.listPush(rem);
                    int dt = ptr1.getData();
                    temp = ( dt ) + ((sum - rem) / (10));
                    // temp = 11;
                    ptr1 = ptr1.getLink();
                    ptr2 = ptr2.getLink();
                    ptr1.setData(temp);
                    // System.out.println("dt " + ptr1.getData());
                    // System.out.println("((sum - rem) / (10)) = " + ((sum - rem) / (10)));
                    // System.out.println("temp = " + temp);
                    // System.out.println("after ptr1.getData()" + ptr1.getData());

                } else {

                    rem = sum % 10;
                    // System.out.println(">9");
                    // System.out.println("rem =" + rem);
                    ans.listPush(rem);
                    // System.out.println("ptr1.getData() " + ptr1.getData());
                    // System.out.println("((sum - rem) / (10)) = " + ((sum - rem) / (10)));
                    // System.out.println("temp = " + temp);
                    // v
                    //

                    ptr1 = ptr1.getLink();
                    ptr2 = ptr2.getLink();
                    temp = ptr1.getData() + ((sum - rem) / (10));

                    ptr1.setData(temp);
                    // System.out.println("after ptr1.getData()" + ptr1.getData());
                }
            }

        }
        // }
        // else {
        //     Node ptr1 = list1.top;
        //     Node ptr2 = list2.top;
        //     while (ptr1 != null) {
        //         sum = ptr1.getData() + ptr2.getData();
        //         if (sum < 9) {
        //             ptr1 = ptr1.getLink();
        //             ptr2 = ptr2.getLink();
        //             ans.listPush(sum);
        //         } else if (sum > 9) {
        //             rem = sum % 10;
        //             ans.listPush(rem);
        //             ptr1 = ptr1.getLink();
        //             ptr2 = ptr2.getLink();
        //             temp = ptr2.getData() + ((sum - rem) / (10));
        //             ptr2.setData(temp);

        //         }

        //     }
        // }




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
