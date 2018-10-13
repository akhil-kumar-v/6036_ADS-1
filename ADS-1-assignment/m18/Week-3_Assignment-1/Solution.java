
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
        BinarysearchST<String, Integer> bst = new
        BinarysearchST<String, Integer>(2);
        int t1 = t;
        sc.nextLine();
        for (int i = 0; i < 6; i++) {
            t = t1;
            if (i == 0) {
                // Stocks st = new Stocks();
                MinPQ<String> minpq = new MinPQ<String>();
                MaxPQ<String> maxpq = new MaxPQ<String>();
                StockArr sa = new StockArr();

                while (t > 0) {
                    t--;
                    String[] line = sc.nextLine().split(",");
                    Stocks st = new Stocks(line[0], Double.parseDouble(line[1]));
                    // parsefoa
                    sa.addToList(st);
                    minpq.insert(line[1]);
                    maxpq.insert(line[1]);
                    // System.out.println(sa);
                }
                sa.selectionSort();
                // System.out.println("---------------- \n" + sa + "\n-----------------");

                for (int k = 0; k < 5; k++) {
                    System.out.println(sa.stk[k].getName() + " "
                                       + sa.stk[k].getStock());

                    // System.out.println(maxpq.getMaxi(k));

                }
                System.out.println();
                int arrsize = sa.getsize();
                // System.out.println("arrsize " + arrsize);
                for (int k = arrsize - 1; k >= arrsize - 5; k--) {
                    // System.out.println("k =" + k);
                    System.out.println(sa.stk[k].getName() + " "
                                       + sa.stk[k].getStock());

                    // System.out.println(minpq.getMini(k));
                }
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

                for (int k = 0; k < 5; k++) {
                    System.out.println(sa.stk[k].getName() + " "
                                       + sa.stk[k].getStock());

                    // System.out.println(maxpq.getMaxi(k));

                }
                System.out.println();
                int arrsize = sa.getsize();
                // System.out.println("arrsize " + arrsize);
                for (int k = arrsize - 1; k >= arrsize - 5; k--) {
                    // System.out.println("k =" + k);
                    System.out.println(sa.stk[k].getName() + " "
                                       + sa.stk[k].getStock());

                    // System.out.println(minpq.getMini(k));
                }

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
        }
    }

    // public static void main(final String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     BinarysearchST<String, Integer> bst = new
    //     BinarysearchST<String, Integer>();
    //     String[] input = sc.nextLine().split(" ");
    //     bst = new BinarysearchST<String, Integer>(input.length);
    //     for (int i = 0; i < input.length; i++) {
    //         bst.put(input[i], i);
    //     }
    //     while (sc.hasNextLine()) {
    //         String[] tokens = sc.nextLine().split(" ");
    //         switch (tokens[0]) {
    //         case "contains":
    //             System.out.println(bst.contains(tokens[1]));
    //             break;
    //         case "get":
    //             System.out.println(bst.get(tokens[1]));
    //             break;
    //         case "max":
    //             System.out.println(bst.max());
    //             break;
    //         case "min":
    //             System.out.println(bst.min());
    //             break;
    //         case "floor":
    //             System.out.println(bst.floor(tokens[1]));
    //             break;
    //         case "rank":
    //             System.out.println(bst.rank(tokens[1]));
    //             break;
    //         case "deleteMin":
    //             bst.deleteMin();
    //             break;
    //         case "keys":
    //             ArrayList<String> limit = bst.keys();
    //             for (int i = 0; i < limit.size(); i++) {
    //                 System.out.println(limit.get(i) + " "
    //                                    + bst.get(limit.get(i)));
    //             }
    //             break;
    //         default:
    //             break;
    //         }
    //     }
    // }
}
