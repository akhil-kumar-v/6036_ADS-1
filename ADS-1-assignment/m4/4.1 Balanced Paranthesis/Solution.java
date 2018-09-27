import java.util.Scanner;
/**
 * Class for my stack class.
 */
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
    public int getTop(){
        return top;
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
    /**
     * Gets the opp.
     *
     * @param      str   The string
     *
     * @return     The opp.
     */
    static String getOpp(final String str) {
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
                if (line[i].equals("{") ||  line[i].equals("(")
                        ||   line[i].equals("[")) {
                    // System.out.println("pusshing = " + line[i]);
                    st.stPush(line[i]);
                } else if (st.top >= 1) {
                    String str = st.stPop();
                    String revstr = getOpp(line[i]);
                    // str = getOpp(line[i]);
                    if (!str.equals(revstr)) {
                        flag = true;
                        System.out.println("NO");
                        break;
                    }
                }
// System.out.println(" stack size = "+ st.top);
            }
            int tp =st.getTop();
            if (!flag && tp == 0) {
                System.out.println("YES");
            } else if (!flag) {
                System.out.println("NO");
            }
        }


    }
}
