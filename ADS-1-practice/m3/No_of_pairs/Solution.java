import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
class Solution {
    static int getcount(Integer[] arr, int val) {
        int c = 0;

        for (int i = 0; i < arr.length; i++) {
            if (val == arr[i]) {
                // System.out.println("matchd =" + val);
                c++;
            }
        }
        return c;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] list = sc.nextLine().split(" ");
        Arrays.sort(list);
        System.out.println(Arrays.toString(list));
        int ans = 0;
        Integer[] intarrayA = new Integer[list.length];
        for (int i = 0; i < list.length; i++) {
            intarrayA[i] = Integer.parseInt(list[i]);
        }

        Set<Integer> set = new HashSet<Integer>(Arrays.asList(intarrayA));
        Integer[] intarrayB = new Integer[set.size()];
        int k = 0;
        for (Integer val : set) {
            intarrayB[k++] = val;
        }
        for (int i = 0; i < intarrayB.length; i++) {
            int curCount = getcount(intarrayA, intarrayB[i]) - 1;
            ans += curCount * ((curCount + 1) / (2));
        }
        System.out.println("Total count = " + ans);
    }
}
