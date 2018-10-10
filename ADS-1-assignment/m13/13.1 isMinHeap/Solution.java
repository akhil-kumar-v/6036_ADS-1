import java.util.Scanner;
/**
 * List of priorities.
 *
 * @param      <E>   { parameter_description }
 */
class PriorityQueue<E extends Comparable<E>> {
    /**
     * Array.
     */
    private E[] arr;
    /**
     * Int size.
     */
    private int size;
    /**
     * Constructs the object.
     *
     * @param      array  The array
     */
    PriorityQueue(final E[] array) {
        this.arr = array;
        size = 0;
    }
    /**
     * Determines if minimum heap.
     *
     * @return     True if minimum heap, False otherwise.
     */
    // Time complexity = O(log N).

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
    /**
     * Returns boolean on comparing 2 items.
     *
     * @param      a     { parameter_description }
     * @param      b     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    // Time complexity = O(1).

    public boolean less(final int a, final int b) {
        return arr[a].compareTo(arr[b]) < 0;
    }
}

/**
 * Class for solution.
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
    // Time complexity = N
    public static void main(final String[] args) {
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
        default:


        }
    }
}
