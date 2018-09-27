import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;



class Solution {
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
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < line.length; i++) {
            if (isAnumber(line[i])) {
                st.push(Integer.parseInt(line[i]));
            } else {
                int a = st.pop();
                int b = st.pop();
                int ans = 0;
                switch (line[i]) {
                case "*":
                    ans = a * b;
                    st.push(ans);
                    break;

                case "+":
                    ans = a + b;
                    st.push(ans);
                    break;

                case "-":
                    ans = a - b;
                    st.push(ans);
                    break;

                case "/":
                    ans = a / b;
                    st.push(ans);
                    break;


                }
            }

        }
        // while (!st.isEmpty()) {
        int myAns=st.pop();
        System.err.println(myAns);
        // }
    }
}
