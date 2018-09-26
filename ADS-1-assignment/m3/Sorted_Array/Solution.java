import java.util.Scanner;
// import java.lang.Math;
// // import java.lang.*;
// import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * { Class solution }.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { Get Mail }.
     *
     * @param      arr   The arr
     *
     * @return     { description_of_the_return_value }
     */
    static String getlow(final List arr) {
        String high = "";
        high = "" + arr.get(0);
        for (int i = 0; i < arr.size(); i++) {
            if (Integer.parseInt("" + arr.get(i)) < Integer.parseInt(high)) {
                high = "" + arr.get(i);
            }

        }


        return high;

    }
    /**
     * { Void main }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int sizeA = sc.nextInt();
        int sizeB = sc.nextInt();
        sc.nextLine();
        String[] arrA = sc.nextLine().split(",");
        String[] arrB = sc.nextLine().split(",");
        // int[] intarrayA = new int[sizeA];
        // int[] intarrayB = new int[sizeB];
        // for (int i = 0; i < sizeA; i++) {
        //     intarrayA[i] = Integer.parseInt(arrA[i]);
        // }
        // System.out.println(Arrays.toString(intarrayA));
        // int i = 0;
        // for (String str : arrB) {
        //     intarrayB[i] = Integer.parseInt(str);
        //     i++;
        // }
        // System.out.println(Arrays.toString(intarrayB));
        // // int[] ans = new int[(sizeA + sizeB)];
        String[] ans = new String[(sizeA + sizeB)];
        System.arraycopy(arrA, 0, ans, 0, sizeA);
        System.arraycopy(arrB, 0, ans, sizeA, sizeB);
        // System.out.println("After copy" + Arrays.toString(ans));

        // Arraylist<Integer> listA;
        // Arraylist<Integer> listB;
        // listA = new ArrayList<>();
        // listB = new ArrayList<>();


        // List<Integer> al = new ArrayList<Integer>(Arrays.asList(ans));
        List<String> ans1 = new ArrayList<String>();
        Collections.addAll(ans1, ans);
        while (ans1.size() > 0) {
            String high = getlow(ans1);
            // System.out.println("every loop" + ans1);
            if (ans1.size() == 1) {
                System.out.print(high);

            } else {
                System.out.print(high + ",");

            }
            ans1.remove(high);
        }
        // System.out.println("qqq" + al);

    }
}
