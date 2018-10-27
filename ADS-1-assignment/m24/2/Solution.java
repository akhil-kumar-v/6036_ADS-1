import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


class Student {
    private String name;
    private int roll;
    private double marks;

    Student(String na, int ro, double ma) {
        this.name = na;
        this.roll = ro;
        this.marks = ma;
    }
    /**
    * Gets the name.
    *
    * @return     The name.
    */
    String getName() {
        return this.name;
    }
    /**
     * Gets the marks.
     *
     * @return     The marks.
     */
    Double getMarks() {
        return this.marks;
    }
    public String toString() {
        return this.name + " " + this.roll + " " +  this.marks;
    }


}

class Solution {
    static ArrayList<Student> stlist;
    Solution() {
        stlist = new ArrayList<Student>();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] rollArr = new int[n];
        Double[] markArr = new Double[n];
        Student[] starr = new Student[n];
        // MyDS ds = new MyDS();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Map<Double, Student> markmap = new HashMap<Double, Student>();

        sc.nextLine();
        int i = 0;
        while (n > 0) {
            n--;
            String[] line = sc.nextLine().split(",");
            Student st = new Student(line[1], Integer.parseInt(line[0]), Double.parseDouble(line[2]));

            rollArr[i] = Integer.parseInt(line[0]);
            markArr[i] = Double.parseDouble(line[2]);
            starr[i] = st;
            // i++;
            // System.out.println(st);
            // stlist.add(st);

            // int s = starr.length;
            // System.out.println("ss " + s);
            map.put(Integer.parseInt(line[0]), i);

            markmap.put(Double.parseDouble(line[2]), st);
            i++;
            // int ind1 = map.get(Double.parseDouble(line[0]));
            // System.out.println("aa " + ind1 + " val = " + starr[ind1] );
        }
        // Merge me = new Merge();
        // me.sort(rollArr);
        // System.out.println("BF =" + Arrays.toString(rollArr));

        MergeSort ob = new MergeSort();
        ob.sort(rollArr, 0, rollArr.length - 1);
        // ob.sort(markArr, 0, markArr.length - 1);
        // ob.
        // for (int i = 0; i < rollArr.length; i++) {

        // }
        // System.out.println("AF =" + Arrays.toString(rollArr));

        int queries = sc.nextInt();
        sc.nextLine();
        while (queries > 0) {
            queries--;
            String[] line = sc.nextLine().split(" ");
            switch (line[0]) {
            case "LE":
                double mrk = Double.parseDouble(line[1]);
                // System.out.println(line[1]);
                // System.out.println(markArr.length);
                // System.out.println(Arrays.asList(map));
                // int ind = map.get(Double.parseDouble(line[1]));
                for (i = markArr.length-1 ; i > 0; i--) {
                    // System.out.println(markArr[i]);
                    if (markArr[i] < mrk) {
                        System.out.println(markmap.get(markArr[i]).getName());

                    }
                }


                // try {
                //     // int ind = map.get(Double.parseDouble(line[0]));

                //     int ind = map.get(Double.parseDouble(line[1]));
                //     System.out.println(ind);
                //     for (i = 0; i < ind; i++) {
                //         System.out.println(starr[i].getName());
                //     }
                // } catch (Exception e) {
                //     // System.out.println(line[1]);
                // }

                break;
            case "GE":
                break;
            case "BE":
                break;
            default:

            }

        }
        // System.out.println(Arrays.toString(rollArr));
    }
}
