import java.util.Scanner;
import java.util.Arrays;

final class Deque {
    private int size;
    private int[] stackArr;
    private int maxsize;

    Deque() {
        maxsize = 10000;
        size = 0;
        stackArr = new int[maxsize];
    }
    void pushLeft(int num) {
        int temp;
        for (int i = size + 1; i > 0; i--) {
            temp = stackArr[i - 1];
            stackArr[i] = temp;
        }
        stackArr[0] = num;
        size++;
        printStack();
        // System.out.println(Arrays.toString(stackArr));
    }
    void pushRight(int num) {
        stackArr[size] = num;
        size++;
        printStack();
        // System.out.println(Arrays.toString(stackArr));

    }
    void popLeft() {

        if (size == 0) {
            System.out.println("Deck is empty");
        } else {
            int value = stackArr[0];
            for (int i = 0; i < size - 1; i++) {
                stackArr[i] = stackArr[i + 1];
            }
            size--;
            printStack();
        }
        // System.out.println(Arrays.toString(stackArr));
        // return value;
    }
    void popRight() {
        if (size == 0) {
            System.out.println("Deck is empty");
        } else {
            size--;
            printStack();
        }
        // System.out.println(Arrays.toString(stackArr));
        // return stackArr[size + 1];
    }
    int getSize() {
        return size ;
    }
    void printStack() {
        if (size == 0) {
            System.out.println("[]");
        }
        for (int i = 0; i < size; i++) {
            if (i == 0 && size == 1) {
                System.out.print("[" + stackArr[i] + "]\n");
                // System.out.print();
            } else if (i == 0 && size != 1) {
                System.out.print("[" + stackArr[i] + ", ");

            } else if (i == size - 1) {
                System.out.print(stackArr[i] + "]\n");
            } else {
                System.out.print(stackArr[i] + ", ");
            }
        }
    }
}

class Solution {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque dq = new Deque();
        int count = sc.nextInt();
        sc.nextLine();
        while (count > 0) {
            count--;
            // System.out.println("-------------");
            String[] line = sc.nextLine().split(" ");
            switch (line[0]) {
            case "pushLeft":
                dq.pushLeft(Integer.parseInt(line[1]));
                break;

            case "pushRight":
                dq.pushRight(Integer.parseInt(line[1]));
                break;
            case "size":
                System.out.println(dq.getSize());
                break;
            case "popLeft":
                // System.out.println("pop le" + dq.popLeft());
                dq.popLeft();
                break;
            case "popRight":
                // System.out.println("pop ri" + dq.popRight());
                dq.popRight();
                break;
            default:

            }
        }
    }
}
