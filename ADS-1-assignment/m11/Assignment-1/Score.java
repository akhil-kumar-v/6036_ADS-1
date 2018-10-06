import java.util.Scanner;
import java.util.Arrays;

class Score {
    String name;
    int[] dob;
    int s1;
    int s2;
    int s3;
    int total;
    String caste;

    Score(String name, int[] dob, int s1,
          int s2, int s3, int total, String caste) {
        this.name = name;
        this.dob = dob;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.total = total;
        this.caste = caste;
    }
    String getName() {
        return name;
    }
    int[] getDOB() {
        return dob;
    }
    int getS1() {
        return s1;
    }

    int getS2() {
        return s2;
    }

    int getS3() {
        return s3;
    }
    int getTotal() {
        return total;
    }
    String getCaste() {
        return caste;
    }
    public int compareTo(Score c) {
        if (this.total > c.total) {
            return 1;
        }
        if (this.total < c.total) {
            return -1;
        }
        if (this.s3 > c.s3) {
            return 1;
        }
        if (this.s3 < c.s3) {
            return -1;
        }
        if (this.s2 > c.s2) {
            return 1;
        }
        if (this.s2 < c.s2) {
            return -1;
        }
        // if (this.s1 > c.s1) {
        //     return 1;
        // }
        // if (this.s1 < c.s1) {
        //     return -1;
        // }
        if (this.dob[0] >= c.dob[0]
                && this.dob[1] >= c.dob[1]
                && this.dob[2] >= c.dob[2]) {
            return 1;
        }
        if (this.dob[0] < c.dob[0]
                && this.dob[1] < c.dob[1]
                && this.dob[2] < c.dob[2]) {
            return -1;
        }
        return 0;
    }
}

class CreateList {
    Score[] scores;
    int size;
    int bc;
    int sc;
    int st;
    CreateList() {
        size = 0;
        bc = 0;
        st = 0;
        sc = 0;
        scores = new Score[100];
    }
    void addToList(Score s) {
        scores[size++] = s;
        if ((s.caste).equals("SC")) {
            sc++;
        } else if ((s.caste).equals("ST")) {
            st++;
        } else if ((s.caste).equals("BC")) {
            bc++;
        }

    }
    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s += scores[i].name + "," + scores[i].total + "," + scores[i].caste + "\n";
        }
        return s;
    }
    public void selectionSort() {
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (less(scores, j, min)) {
                    min = j;
                }
            }
            exch(scores, i, min);
        }
        // Solution ss = new Solution();
        // int bccount= ss.bcVac;
        // int sccount= ss.scVac;
        // int stcount= ss.stVac;
        // System.out.println("stcount =" + stcount);
        // System.out.println("bccount =" + bccount);
        // System.out.println("sccount =" + sccount);
        // for (int i = 0; i < size; i++) {
        //     System.out.println(scores[i].name + ","
        //                        + scores[i].total + ","
        //                        + scores[i].caste );
        // }

    }
    public void exch(Score[] scores, int i, int j) {
        Score ct = scores[j];
        scores[j] = scores[i];
        scores[i] = ct;
    }
    boolean less(Score[] arr, int i, int j) {
        return  arr[i].compareTo(arr[j]) > 0;
    }
}
