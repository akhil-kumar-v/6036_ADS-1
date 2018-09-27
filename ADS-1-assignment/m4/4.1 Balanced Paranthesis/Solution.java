import java.util.Scanner;
class MyStackClass {
    /**
    * { int top }.
    */
    static int top;
    /**
     * { int MAXSIZE }.
     */
    private int maxSize;
    /**
     * { int[] stack Array }.
     */
    private static String[] stackArr;
    /**
     * Constructs the object.
     *
     * @param      size  The size
     */
    MyStackClass(final int size) {
        top = -1;
        maxSize = size;
        stackArr = new String[maxSize];
    }
    /**
     * { Push in stack }.
     *
     * @param      val   The value
     */
    static void stPush(final String val) {
        // System.out.println("top = " + top);
        // top-=1;
        stackArr[++top] = val;
    }

    /**
     * Pop from stack.
     *
     * @return     { Returns poped values }
     */
    static String stPop() {
        // System.out.println("top = " + top);
        return stackArr[top--];
    }
    /**
     * Determines if anumber.
     *
     * @param      num   The number
     *
     * @return     True if anumber, False otherwise.
     */


}
/**
 * { Class Solution }.
 */
final class Solution {

    static String getOpp(String str) {
        if (str.equals(")")) {
            return "(";
        } else if (str.equals("}")) {
            return "{";
        } else if (str.equals("]")) {
            return "[";
        }
        return "num";
    }
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { Main function }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        int open = 0, close = 0;
        boolean flag = false;

        // System.out.println("t = " + t);
        while (t > 0) {
            // System.out.println("--------------------------------------");
            t--;
            // flag = false;
            flag = false;
            // System.out.println("new t =" + t);
            int c1 = 0, c2 = 0, c3 = 0;
            String[] line = sc.nextLine().split("");
            MyStackClass st = new MyStackClass(line.length);
            // System.out.println(Arrays.toString(line));
            // System.out.println("line.length = " + line.length);
            for (int i = 0; i < line.length; i++) {
                // System.out.println(  "hello");
                if (line[i].equals("{") ||  line[i].equals("(") ||   line[i].equals("[")) {
                    // System.out.println("pusshing = " + line[i]);
                    st.stPush(line[i]);
                } else if (st.top >= 1) {
                    // System.out.println("else is heere with  = " + line[i]);
                    String str = st.stPop();
                    String revstr = getOpp(line[i]);
                    // str = getOpp(line[i]);
                    // System.out.println("str =" + str + "revstr = " + revstr);
                    if (!str.equals(revstr)) {
                        // System.out.println("NO when str = " + str + " and revstr " + revstr);
                        flag = true;
                        System.out.println("NO");
                        break;
                    }
                }
// System.out.println(" stack size = "+ st.top);
            }
            // if (flag) {
            //     System.out.println("ochesa ikadiki");
            //     break;
            // }
            // if (c1 == 0 && c2 == 0 && c3 == 0) {
            //     System.out.println("YES");
            // } else {
            //     System.out.println("NO");
            // }
            if (!flag && st.top == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");

            }
        }


    }
}
