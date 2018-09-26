import java.util.Scanner;
import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Integer.parseInt();
        int count =  Integer.parseInt(sc.nextLine());
        int[] list;
        int ans = 0;
        // System.out.println("counr " + count);
        list = new int[count];
        for (int i = 0; i < count ; i++) {
            // if (i % 100 == 0) System.out.println("100 " + i);
            int a =  Integer.parseInt(sc.nextLine());
            list[i] = a;
        }
        // System.out.println(Arrays.toString(list));
        // for (int i = 0; i < count ; i++) {
        //     for (int j = i + 1; j < count; j++) {
        //         for (int k = j + 1; k < count; k++) {
        //             if (list[i] + list[j] + list[k] == 0) {
        //                 ans++;
        //             }
        //         }
        //     }
        // }
        Arrays.sort(list);
        // System.out.println("-----------------------------------------------------");

        // System.out.println(Arrays.toString(list));

        // System.out.println("-----------------------------------------------------");
        int pop = 0;
        // System.out.println("ochesa ikkadiki");
        for (int i = 0; i < count - 2; i++) {
            // System.out.println();
            int j = i + 1;
            int k = count -1;
            while (k >= j) {
                int sum = list[i] + list[j] + list[k];
                if ( sum == 0) {
                    // System.out.format("list[i] =%d list[j] =%d list[k] =%d\n", list[i] , list[j] , list[k]);
                    // System.out.format("i=%d | j=%d | k=%d \n", i, j, k);
                    // System.out.println("Sum = " + sum);
                    ans++;
                    // System.out.println("ans here = " + ans);
                    // pop = 1;
                    // break;
                }
                // (A[i] + A[j] + A[k] > 0) ? k-- : j++
                if (sum > 0) {
                    k--;
                } else {
                    j++;
                }

            }
            // if (pop == 1) {
            //     break;
            // }
        }




        //--------------------
        //--------------------
        //--------------------
        //--------------------
        // for (Int val: list) {
        //     ele = list[i] - 0;
        //     // let front be the pointer to the front of the array;
        //     // let rear be the pointer to the rear element of the array.;
        //     int front=i;
        //     int rear=count;
        //     // till front is not greater than rear.
        //     while (front <= rear) {
        //         if ( *front + * rear == ele) {
        //             print "Found triplet " << * front << "," << * rear << "," << ele << endl;
        //             break;
        //         } else {
        //             // sum is > ele, so we need to decrease the sum by decrementing rear pointer.
        //             if (( * front + * rear) > ele)
        //                 decrement rear pointer.
        //                 // sum is < ele, so we need to increase the sum by incrementing the front pointer.
        //                 else
        //                     increment front pointer.
        //                 }
        //     }
        //------------------------------------------------
        //------------------------------------------------
        //------------------------------------------------

        // System.out.println("test");
        // System.out.println("newwwww = " + ans);
        System.out.println(ans);
    }
}
