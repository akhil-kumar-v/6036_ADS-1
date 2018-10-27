import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;


class Student {
    String name;
    int roll;
    double marks;

    Student(String na, int ro, double ma) {
        this.name = na;
        this.roll = ro;
        this.marks = ma;
    }
    public String toString() {
        return this.name + " " + this.roll + " " +  this.marks;
    }


}

class StudentList {
    Node root;
    class Node {
        Student stobj;
        Node left;
        Node right;

    }

    void addNode(int roll) {


    }
}

// class StudentArr<E extends Comparable<E>> {
//     private E[] arr1;
//     int size;
//     StudentArr(E[] array) {
//         this.arr1 = array;
//         size = 0;
//     }
//     void addarr(E val){
//         arr1[size++]=val;
//     }

// }


class Solution {
    static ArrayList<Student> stlist;
    Solution() {
        stlist = new ArrayList<Student>();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // StudentArr sa = new StudentArr();
        // sa.arr1
        int[] arr = new int[n];
        MyDS ds = new MyDS();
        Map<Integer, Student> map = new HashMap<Integer, Student>();

        sc.nextLine();
        int i = 0;
        while (n > 0) {
            n--;
            String[] line = sc.nextLine().split(",");
            Student st = new Student(line[1], Integer.parseInt(line[0]), Double.parseDouble(line[2]));
            ds.add(Integer.parseInt(line[0]));
            // System.out.println(st);
            arr[i] = Integer.parseInt(line[0]);
            i++;
            map.put(Integer.parseInt(line[0]), st);
            // try {
            //     stlist.add(st);
            // } catch (Exception e) {
            //     System.out.println(e.getMessage());
            // }
        }
        // Merge me = new Merge();
        // me.sort(arr);
        // System.out.println("BF =" + Arrays.toString(arr));


        // System.out.println(ds.search(101));

        MergeSort ob = new MergeSort();

        ob.sort(arr, 0, arr.length - 1);


        // System.out.println("AF =" + Arrays.toString(arr));




        int q = sc.nextInt();
        sc.nextLine();
        while (q > 0) {
            q--;
            // System.out.println("test");

            String[] line = sc.nextLine().split(" ");
            // System.out.println(line[2]);
            if (line[2].equals("1")) {
                // System.out.println("test");
                Student temp = map.get(Integer.parseInt(line[1]));
                System.out.println(temp.name);
            } else if (line[2].equals("2")) {
                Student temp = map.get(Integer.parseInt(line[1]));
                System.out.println(temp.marks);
            }
        }
    }
}

