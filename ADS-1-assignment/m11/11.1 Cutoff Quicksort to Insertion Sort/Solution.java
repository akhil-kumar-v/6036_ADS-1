import java.util.Scanner;
/**
 * Class for sorting.
 */
class Sorting {
    /**
     * Constructs the object.
     */
    Sorting() {
    }
    /**
     * Method for insertion.
     *
     * @param      arr   The arr
     * @param      low   The low
     * @param      high  The high
     */
    public void insertion(final Comparable[] arr, final int low,
                          final int high) {
        for (int i = low; i <= high; i++) {
            for (int j = i; j > low && less(arr[j], arr[j - 1]); j--) {
                swap(arr, j, j - 1);
            }
        }
    }
    /**
     * Swapping items.
     *
     * @param      arr   The arr
     * @param      j     { parameter_description }
     * @param      min   The minimum
     */
    public void swap(final Comparable[] arr, final int j, final int min) {
        Comparable temp = arr[j];
        arr[j] = arr[min];
        arr[min] = temp;
    }
    /**
     * Returns a string representation of the object.
     *
     * @param      arr   The arr
     *
     * @return     String representation of the object.
     */
    public String toString(final Comparable[] arr) {
        // System.out.println("in print");
        String str = "[";
        for (int i = 0; i < arr.length - 1; i++) {
            str += arr[i] + ", ";
        }
        str += arr[arr.length - 1] + "]";
        return str;
    }
    /**
     * Sort Function.
     *
     * @param      arr     The arr
     * @param      low     The low
     * @param      high    The high
     * @param      cutOff  The cut off
     */
    public void sort(final Comparable[] arr, final int low,
                     final int high, final int cutOff) {
        if (high <= low + cutOff - 1) {
            insertion(arr, low, high);
            System.out.println("insertionSort called");
            return;
        }
        int k = partition(arr, low, high);
        System.out.println(toString(arr));
        sort(arr, low, k - 1, cutOff);
        sort(arr, k + 1, high, cutOff);
    }
    /**
     * Sort Over Riding.
     *
     * @param      array   The array
     * @param      cutOff  The cut off
     */
    public void sort(final Comparable[] array, final int cutOff) {
        sort(array, 0, array.length - 1, cutOff);
    }
    /**
     * Partition the Array.
     *
     * @param      arr   The arr
     * @param      low   The low
     * @param      high  The high
     *
     * @return     { description_of_the_return_value }
     */
    public int partition(final Comparable[] arr,
                         final int low, final int high) {
        int i = low;
        int j = high + 1;
        while (true) {
            while (less(arr[++i], arr[low])) {
                if (i == high) {
                    break;
                }
            }
            while (less(arr[low], arr[--j])) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(arr, i, j);
        }
        swap(arr, low, j);
        return j;
    }
    /**
     * Comparable.
     *
     * @param      a     { parameter_description }
     * @param      b     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public boolean less(final Comparable a, final Comparable b) {
        return a.compareTo(b) < 0;
    }
}
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
        Scanner sc = new Scanner(System.in);
        Sorting sort = new Sorting();
        int testcases = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < testcases; i++) {
            int j = Integer.parseInt(sc.nextLine());
            // sc.nextLine();
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            if (tokens[0].equals("")) {
                System.out.println("[]");
            } else {
                sort.sort(tokens, j);
                System.out.println(sort.toString(tokens));
            }
        }
    }
}
