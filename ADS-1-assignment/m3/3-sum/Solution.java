import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        // Integer.parseInt();
        int count =  Integer.parseInt(sc.nextLine());
        int[] list;
        int ans = 0;
        // System.out.println("counr " + count);
        list = new int[count];
        for (int i = 0; i < count; i++) {
            // if (i % 100 == 0) System.out.println("100 " + i);
            int a =  Integer.parseInt(sc.nextLine());
            list[i] = a;
        }
        Arrays.sort(list);
        int pop = 0;
        // System.out.println("ochesa ikkadiki");
        final int three = 3;
        for (int i = 0; i < count - three; i++) {
            // System.out.println();
            int j = i + 1;
            int k = count - 1;
            while (k > j) {
                int sum = list[i] + list[j] + list[k];
                if ( sum == 0) {
                    ans++;
                }
                if (sum > 0) {
                    k--;
                } else {
                    j++;
                }

            }
        }
        System.out.println(ans);
    }
}
