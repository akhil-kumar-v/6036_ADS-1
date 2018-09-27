import java.util.Scanner;
// import java.util.Stack;
import java.util.Arrays;



class Solution {
    static private int top;
    static private int MAXSIZE;
    static private int[] stackArr;
    Solution() {
        top = -1;
        MAXSIZE = 100;
        stackArr = new int[MAXSIZE];
    }

    static void stPush(int val) {
        // System.out.println("top = " + top);
        // top-=1;
        stackArr[++top] = val;
    }
    static int stPop() {
        return stackArr[top--];
    }


    static boolean isAnumber(String num) {
        try {
            int a = Integer.parseInt(num);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        // System.out.println(Arrays.toString(line));
        Solution st = new Solution();
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


                }
            }

        }
        // while (!st.isEmpty()) {
        int myAns = st.stPop();
        System.err.println(myAns);
        // }
    }
}
