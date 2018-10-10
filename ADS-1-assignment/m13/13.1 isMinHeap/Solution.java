import java.util.Scanner;
import java.util.Arrays;
class PriorityQueue<E extends Comparable<E>> {
    private E[] arr;
    int size;
    PriorityQueue(E[] array) {
        this.arr = array;
        size = 0;
    }
    public boolean isMinHeap() {
        for (int i = 1; i < arr.length; i++) {
            if (2 * i < arr.length && less(2 * i, i)) {
                return false;
            }
            if ((2 * i) + 1 < arr.length && less(2 * i + 1, i)) {
                return false;
            }
        }
        return true;
    }
    public boolean less(int a, int b) {
        return arr[a].compareTo(arr[b]) < 0;
    }
}


class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dataType = sc.nextLine();
        int testcases = Integer.parseInt(sc.nextLine());

        switch (dataType) {
        case "String":
            while (testcases > 0) {
                testcases--;
                String[] tokens = sc.nextLine().split(",");
                PriorityQueue<String> pq =
                    new PriorityQueue<String>(tokens);
                if (tokens[0].equals("")) {
                    System.out.println("false");
                } else {
                    System.out.println(pq.isMinHeap());
                }
            }
            break;
        case "Float":
            // testcases = Integer.parseInt(sc.nextLine());
            while (testcases > 0) {
                testcases--;
                String[] tokens = sc.nextLine().split(",");
                Float[] fltArray = new Float[tokens.length];
                if (tokens[0].equals("")) {
                    System.out.println("false");
                } else {
                    for (int j = 0; j < tokens.length; j++) {
                        fltArray[j] = Float.parseFloat(tokens[j]);
                    }
                    PriorityQueue<Float> pq =
                        new PriorityQueue<Float>(fltArray);
                    System.out.println(pq.isMinHeap());
                }

            }
            break;
        case "Double":
            // testcases = Integer.parseInt(sc.nextLine());
            while (testcases > 0) {
                testcases--;
                String[] tokens = sc.nextLine().split(",");
                Double[] dbleArray =
                    new Double[tokens.length];
                if (tokens[0].equals("")) {
                    System.out.println("false");
                } else {
                    for (int j = 0; j < tokens.length; j++) {
                        dbleArray[j] = Double.parseDouble(tokens[j]);
                    }
                    PriorityQueue<Double> pq =
                        new PriorityQueue<Double>(dbleArray);
                    System.out.println(pq.isMinHeap());
                }
            }
            break;
        case "Integer":
            // testcases = Integer.parseInt(sc.nextLine());
            while (testcases > 0) {
                testcases--;
                String[] tokens = sc.nextLine().split(",");
                Integer[] intArray = new Integer[tokens.length];
                if (tokens[0].equals("")) {
                    System.out.println("false");
                } else {
                    for (int j = 0; j < tokens.length; j++) {
                        intArray[j] = Integer.parseInt(tokens[j]);
                    }
                    PriorityQueue<Integer> pq =
                        new PriorityQueue<Integer>(intArray);
                    System.out.println(pq.isMinHeap());
                }

            }
            break;

        }
    }
}
