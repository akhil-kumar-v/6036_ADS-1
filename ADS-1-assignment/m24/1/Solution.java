import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

/**
 * Class for student.
 */
class Student {
    /**
     * Student Name.
     */
    private String name;
    /**
     * Student Roll.
     */
    private int roll;
    /**
     * Student marks.
     */
    private double marks;
    /**
     * Constructs the object.
     *
     * @param      na    { parameter_description }
     * @param      ro    { parameter_description }
     * @param      ma    { parameter_description }
     */
    Student(final String na, final int ro, final double ma) {
        /**
         * name.
         */
        this.name = na;
        /**
         * Roll no.
         */
        this.roll = ro;
        /**
         * Marks.
         */
        this.marks = ma;
    }
    String getName() {
        return this.name;
    }
    Double getMarks() {
        return this.marks;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return this.name + " " + this.roll + " " +  this.marks;
    }

}


/**
 * Class for solution.
 */
class Solution {
    /**
     * Constructs the object.
     */
    Solution() {
    }
    /**
     * Main.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        Map<Integer, Student> map = new HashMap<Integer, Student>();
        sc.nextLine();
        // int i = 0;
        while (n > 0) {
            n--;
            String[] line = sc.nextLine().split(",");
            Student st = new Student(line[1], Integer.parseInt(line[0]), Double.parseDouble(line[2]));
            // arr[i] = Integer.parseInt(line[0]);
            // i++;
            map.put(Integer.parseInt(line[0]), st);
        }
        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);
        int q = sc.nextInt();
        sc.nextLine();

        while (q > 0) {
            q--;
            String[] line = sc.nextLine().split(" ");
            // System.out.println(line[2]);
            if (line[2].equals("1")) {
                // System.out.println("test");
                Student temp = map.get(Integer.parseInt(line[1]));
                try {
                    System.out.println(temp.getName());

                } catch (Exception e) {
                    System.out.println("Student doesn't exists...");
                }
            } else if (line[2].equals("2")) {
                Student temp = map.get(Integer.parseInt(line[1]));
                try {
                    System.out.println(temp.getMarks());

                } catch (Exception e) {
                    System.out.println("Student doesn't exists...");
                }
            }
        }
    }
}

