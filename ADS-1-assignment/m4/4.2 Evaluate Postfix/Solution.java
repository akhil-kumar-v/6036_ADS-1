import java.util.Scanner;
// import java.util.Stack;
// import java.util.Arrays;

/**
 * Class for solution.
 */

final class Solution {
    /**
     * { int top }.
     */
    static private int top;
    /**
     * { int MAXSIZE }.
     */
    static private int maxSize;
    /**
     * { int[] stack Array }.
     */
    static private int[] stackArr;
    /**
     * Constructs the object.
     *
     * @param      size  The size
     */
    private Solution(final int size) {
        top = -1;
        maxSize = size;
        stackArr = new int[maxSize];
    }
    /**
     * { Push in stack }.
     *
     * @param      val   The value
     */
    static void stPush(final int val) {
        // System.out.println("top = " + top);
        // top-=1;
        stackArr[++top] = val;
    }
    /**
     * Pop from stack.
     *
     * @return     { Returns poped values }
     */
    static int stPop() {
        return stackArr[top--];
    }
    /**
     * Determines if anumber.
     *
     * @param      num   The number
     *
     * @return     True if anumber, False otherwise.
     */

    static boolean isAnumber(final String num) {
        try {
            int a = Integer.parseInt(num);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        // System.out.println(Arrays.toString(line));
        Solution st = new Solution(100);
        for (int i = 0; i < line.length; i++) {
            if (isAnumber(line[i])) {
                st.stPush(Integer.parseInt(line[i]));
            } else {
                int a = st.stPop();
                int b = st.stPop();
                int ans = 0;
                switch (line[i]) {
                case "*":
                    ans = a * b;
                    st.stPush(ans);
                    break;
                case "+":
                    ans = a + b;
                    st.stPush(ans);
                    break;
                case "-":
                    ans = a - b;
                    st.stPush(ans);
                    break;
                case "/":
                    ans = a / b;
                    st.stPush(ans);
                    break;
                default:

                }
            }

        }
        // while (!st.isEmpty()) {
        int myAns = st.stPop();
        System.err.println(myAns);
        // }
    }
}
