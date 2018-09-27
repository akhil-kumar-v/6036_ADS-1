import java.util.Scanner;

/**
 * { Class Solution }.
 */
final class Solution {
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
        // System.out.println("t = " + t);
        while (t > 0) {
            t--;
            // System.out.println("new t =" + t);
            int c1 = 0, c2 = 0, c3 = 0;
            String[] line = sc.nextLine().split("");
            // System.out.println(Arrays.toString(line));
            // System.out.println("line.length = " + line.length);
            for (int i = 0; i < line.length; i++) {

                switch (line[i]) {
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

            }
            if (c1 == 0 && c2 == 0 && c3 == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
