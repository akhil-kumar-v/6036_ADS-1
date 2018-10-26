import java.util.Scanner;
import java.util.Arrays;


/**
 * Class for hash table.
 */
class HashTable {
    /**
     * Class for node.
     */
    class Node {
        /**
         * String key.
         */
        private String key;
        /**
         * Integer data.
         */
        private Integer data;
        /**
         * Node link.
         */
        private Node next;
        /**
         * Constructs the object.
         *
         * @param      ky    { parameter_description }
         * @param      da    { parameter_description }
         * @param      ne    { parameter_description }
         */
        Node(String ky, Integer da, Node ne) {
            this.key = ky;
            this.data = da;
            this.next = ne;
        }
        /**
         * Get key.
         *
         * @return     returns key.
         */
        String getkey() {
            return this.key;
        }
        /**
         * Gets the data.
         *
         * @return     The data.
         */
        Integer getData() {
            return this.data;
        }
        /**
         * Gets the next.
         *
         * @return     The next.
         */
        Node getNext() {
            return this.next;
        }
        /**
         * Sets the data.
         *
         * @param      da    { parameter_description }
         */
        void setData(Integer da) {
            this.data = da;
        }
    }
    /**
     * Arrays of type Node.
     */
    Node[] st;
    /**
     * Size.
     */
    final int size = 100;
    /**
     * Constructs the object.
     */
    HashTable() {
        st = new Node[size];
    }
    /**
     * Has Function.
     *
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    int hash(final String k) {
        final int con = 0x7fffffff;
        return (k.hashCode() & con) % size;
    }

    /**
    * Resizes the array.
    */
    public void resize() {
        st = Arrays.copyOf(st, 2 * size);
    }
    /**
    * Puts the value in HashTable.
    *
    * @param      k     String.
    * @param      v     Count.
    */
    public void put(final String k, final Integer v) {
        int i = hash(k);
        for (Node x = st[i]; x != null; x = x.next) {
            if (k.equals(x.getkey())) {
                x.setData(x.getData() + 1);
                return;
            }
        }
        if (i >= st.length) {
            resize();
        }
        st[i] = new Node(k, v, st[i]);
    }
    public boolean get(final String k) {
        int i = hash(k);
        for (Node x = st[i]; x != null; x = x.next) {
            if (k.equals(x.getkey())) {
                if (x.getData() > 0) {
                    x.setData(x.getData() - 1);
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}



class Solution {
    /**
     * Constructs the object.
     */
    Solution() {

    }
    /**
     * Main Funtion.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        boolean flag = true;
        sc.nextLine();
        String[] magazine = sc.nextLine().split(" ");
        String[] note = sc.nextLine().split(" ");
        HashTable h = new HashTable();
        for (int i = 0; i < m; i++) {
            h.put(magazine[i], 1);
        }
        for (int i = 0; i < n; i++) {
            if (!h.get(note[i])) {
                flag = false;
                System.out.println("No");
                break;
            }
        }
        if (flag) {
            System.out.println("Yes");
        }
    }
}
