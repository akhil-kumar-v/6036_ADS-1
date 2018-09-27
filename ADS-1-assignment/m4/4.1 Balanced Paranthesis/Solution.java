import java.util.Scanner;
import java.util.Arrays;


final class Solution {
    private Solution() {

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        int open = 0, close = 0;
        // System.out.println("t = " + t);
        while (t > 0) {
            t--;
            // System.out.println("new t =" + t);
            int c1 = 0, c2 = 0, c3 = 0;
            String[] line = sc.nextLine().split("");
            // System.out.println(Arrays.toString(line));
            // System.out.println("line.length = " + line.length);
            for (int i = 0; i < line.length; i++) {

                switch(line[i]) {
                case "[":
                    c1++;
                    break;

                case "{":
                    c2++;
                    break;

                case "(":
                    c3++;
                    break;

                case "]":
                    c1--;
                    break;

                case "}":
                    c2--;
                    break;

                case ")":
                    c3--;
                    break;
                default:


                }




                // // System.out.println("i am for i = " + i + "line [" + i + "] = " + line[i]);
                // if (line[i].equals("{") || line[i].equals("(") || line[i].equals("[")) {
                //     // System.out.println("****************************************");
                //     // System.out.println("bf open = " + open);
                //     open++;
                //     // System.out.println("af open = " + open);

                // } else if (line[i].equals("}") || line[i].equals(")") || line[i].equals("]")) {
                //     // System.out.println(" ------------------------------- ");

                //     // System.out.println("bf close = " + close);

                //     close++;
                //     // System.out.println(" af close = " + close);

                // }
            }
            if (c1 == 0 && c2 == 0 && c3 == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
