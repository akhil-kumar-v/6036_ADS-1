
import java.util.Scanner;
import java.util.ArrayList;

class StockArr {
    Stocks[] stk;
    int size;
    StockArr() {
        stk = new Stocks[50];
        size = 0;
    }
    void addToList(Stocks s) {
        stk[size++] = s;
    }
    int getsize() {
        return size;
    }
    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s += stk[i].name + " " + stk[i].stock + "\n";
        }
        return s;
    }
    public void selectionSort() {
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (less(stk, j, min)) {
                    min = j;
                }
            }
            exch(stk, i, min);
        }

    }
    public void exch(Stocks[] stk, int i, int j) {
        Stocks ct = stk[j];
        stk[j] = stk[i];
        stk[i] = ct;
    }
    boolean less(Stocks[] arr, int i, int j) {
        return  arr[i].compareTo(arr[j]) > 0;
    }
}

class Stocks {
    String name;
    Double stock;
    Stocks() {

    }
    Stocks(String name, Double stock) {
        this.name = name;
        this.stock = stock;
    }
    String getName() {
        return name;
    }
    Double getStock() {
        return stock;
    }
    public int compareTo(Stocks c) {
        if (this.stock > c.stock) {
            return 1;
        }
        if (this.stock < c.stock) {
            return -1;
        }
        int compare = this.name.compareTo(c.name);

        if (compare > 0) {
            return 1;
            //a is smaller
        } else if (compare < 0) {
            return -1;
            //a is larger
        }
        return 0;
    }
}


class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * Main.
     *
     * @param      args  The arguments
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        BinarysearchST<String, Integer> bsthg = new
        BinarysearchST<String, Integer>(2);
        BinarysearchST<String, Integer> bstlw = new
        BinarysearchST<String, Integer>(2);
        int t1 = t;
        sc.nextLine();
        for (int i = 0; i < 6; i++) {
            t = t1;
            if (i == 0) {
                // Stocks st = new Stocks();

                StockArr sa = new StockArr();

                while (t > 0) {
                    t--;
                    String[] line = sc.nextLine().split(",");
                    Stocks st = new Stocks(line[0], Double.parseDouble(line[1]));
                    // parsefoa
                    sa.addToList(st);

                    // System.out.println(sa);
                }
                sa.selectionSort();
                // System.out.println("---------------- \n" + sa + "\n-----------------");
                MinPQ<String> minpq = new MinPQ<String>();
                MaxPQ<String> maxpq = new MaxPQ<String>();
                for (int j = 1; j < t1 + 1; j++) {
                    minpq.insert("" + sa.stk[j - 1].getStock());
                    maxpq.insert("" + sa.stk[j - 1].getStock());
                }


                // for (int k = 0; k < 5; k++) {
                //     System.out.println(sa.stk[k].getName() + " "
                //                        + sa.stk[k].getStock());


                // }

                for (int k = 1; k < 6; k++) {
                    if ( ( bsthg.get(sa.stk[k - 1].getName()) ) == null) {
                        bsthg.put(sa.stk[k - 1].getName(), 1);
                    } else {
                        int count = bsthg.get(sa.stk[k - 1].getName());
                        bsthg.put(sa.stk[k - 1].getName(), (count + 1));
                    }
                    System.out.println(sa.stk[k - 1].getName() + " " + sa.stk[k - 1].getStock());
                }
                System.out.println();
                int b = t1 - 1;
                for (int k = 1; k < 6; k++) {
                    if (bstlw.get(sa.stk[b].getName()) == null) {
                        // System.out.println(bstlw.get(sa.stk[b].getName()) == null);
                        bstlw.put(sa.stk[b].getName(), 1);
                    } else {
                        int count = bstlw.get(sa.stk[b].getName());
                        bstlw.put(sa.stk[b].getName(), (count + 1));
                    }
                    // System.out.println(sa.stk[b].getName() + " " + minpq.getMini(k)
                    //                    + "here =" + sa.stk[b--].getStock());
                    System.out.println(sa.stk[b].getName() + " " + sa.stk[b].getStock());
                    b--;
                }

                // System.out.println();
                // int arrsize = sa.getsize();
                // System.out.println("arrsize " + arrsize);
                // for (int k = arrsize - 1; k >= arrsize - 5; k--) {
                //     // System.out.println("k =" + k);
                //     System.out.println(sa.stk[k].getName() + " "
                //                        + sa.stk[k].getStock());

                //     // System.out.println(minpq.getMini(k));
                // }
                System.out.println();

            } else {
                StockArr sa = new StockArr();
                MinPQ<String> minpq1 = new MinPQ<String>();
                MaxPQ<String> maxpq1 = new MaxPQ<String>();
                while (t > 0) {
                    t--;

                    String[] line = sc.nextLine().split(",");
                    Stocks st = new Stocks(line[0], Double.parseDouble(line[1]));
                    sa.addToList(st);

                    minpq1.insert(line[1]);
                    maxpq1.insert(line[1]);


                }
                sa.selectionSort();
                // System.out.println("---------------- \n" + sa + "\n-----------------");
                for (int j = 1; j < t1 + 1; j++) {
                    minpq1.insert("" + sa.stk[j - 1].getStock());
                    maxpq1.insert("" + sa.stk[j - 1].getStock());
                }



                for (int k = 1; k < 6; k++) {
                    if (bsthg.get(sa.stk[k - 1].getName()) == null) {
                        bsthg.put(sa.stk[k - 1].getName(), 1);
                    } else {
                        int count = bsthg.get(sa.stk[k - 1].getName());
                        bsthg.put(sa.stk[k - 1].getName(), (count + 1));
                    }


                    // bstlw.put();
                    System.out.println(sa.stk[k - 1].getName() + " " + sa.stk[k - 1].getStock());
                }

                System.out.println();
                int b = t1 - 1;
                for (int k = 1; k < 6; k++) {
                    if (bstlw.get(sa.stk[b].getName()) == null) {
                        bstlw.put(sa.stk[b].getName(), 1);
                    } else {
                        int count = bstlw.get(sa.stk[b].getName());
                        bstlw.put(sa.stk[b].getName(), (count + 1));
                    }
                    // System.out.println(sa.stk[b].getName() + " " + minpq.getMini(k)
                    //                    + "here =" + sa.stk[b--].getStock());
                    System.out.println(sa.stk[b].getName() + " " + sa.stk[b].getStock());
                    b--;
                }

                // System.out.println();

                /// old print >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>



                // for (int k = 0; k < 5; k++) {
                //     System.out.println(sa.stk[k].getName() + " "
                //                        + sa.stk[k].getStock());

                //     // System.out.println(maxpq.getMaxi(k));

                // }
                // System.out.println();
                // int arrsize = sa.getsize();
                // // System.out.println("arrsize " + arrsize);
                // for (int k = arrsize - 1; k >= arrsize - 5; k--) {
                //     // System.out.println("k =" + k);
                //     System.out.println(sa.stk[k].getName() + " "
                //                        + sa.stk[k].getStock());

                //     // System.out.println(minpq.getMini(k));
                // }



                /// old print >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>




                // for (int k = 1; k < 6; k++) {
                //     // System.out.println(sa.stk[i]);
                //     System.out.println(maxpq1.getMaxi(k));

                // }
                // System.out.println();
                // for (int k = 1; k < 6; k++) {
                //     // System.out.println(sa.stk[i]);

                //     System.out.println(minpq1.getMini(k));

                // }
                System.out.println();

            }



        }
        int query = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < query; i++) {
            String[] line = sc.nextLine().split(",");
            switch (line[0]) {
            case "get":
                if (line[1].equals("minST")) {
                    if (bstlw.get(line[2]) == null) {
                        // System.out.print(line[2] + " = ");
                        System.out.println(0);
                    } else {
                        System.out.println(bstlw.get(line[2]));
                    }
                } else {
                    if (bsthg.get(line[2]) == null) {
                        // System.out.print(line[2] + " = ");

                        System.out.println(0);
                    } else {
                        System.out.println(bsthg.get(line[2]));

                    }

                }
                break;
            case "intersection":
                                            // System.out.println("asa");

                ArrayList<String> l1 = bstlw.keys();
                ArrayList<String> l2 = bsthg.keys();

                for ( i = 0; i < l1.size(); i++) {
                    for (int j = 0; j < l2.size(); j++) {
                        if (l1.get(i).equals((l2.get(j)))) {
                                // System.out.println("asa");
                            System.out.println( l1.get(i) );
                            // System.out.println("l2" + l2.get(i));
                            // break;
                        }
                    }
                }
                break;

            }

        }
    }


}
