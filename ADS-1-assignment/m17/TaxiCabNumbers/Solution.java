import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
class CubeSum implements Comparable<CubeSum> {
    /**
     * Int sum.
     */
    private final int sum;
    /**
     * Int i.
     */
    private final int i;
    /**
     * Int j.
     */
    private final int j;
    /**
     * Constructs the object.
     *
     * @param      ik    { parameter_description }
     * @param      jk    { parameter_description }
     */
    CubeSum(final int ik, final int jk) {
        this.sum = ik * ik * ik + jk * jk * jk;
        this.i = ik;
        this.j = jk;
    }
    /**
     * Compars.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final CubeSum that) {
        if (this.sum < that.sum) {
            return -1;
        }
        if (this.sum > that.sum) {
            return +1;
        }
        return 0;
    }
    /**
     * Get i.
     *
     * @return     i
     */
    int geti() {
        return this.i;
    }
    /**
     * Get j.
     *
     * @return     j
     */
    int getj() {
        return this.j;
    }
    /**
     * returns sum.
     *
     * @return     { description_of_the_return_value }
     */
    int getsum() {
        return this.sum;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return sum + " = " + i + "^3" + " + " + j + "^3";
    }
}
/**
 * Class for minimum pq.
 *
 * @param      <Key>  The key
 */
class MinPQ<Key> implements Iterable<Key> {
    /**
     * PQ arary of type Key.
     */
    private Key[] pq;
    /**
     * number n.
     */
    private int n;
    /**
     * Comparoter obj.
     */
    private Comparator<Key> comparator;
    /**
     * Constructs the object.
     *
     * @param      initCapacity  The initialize capacity
     */
    MinPQ(final int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }
    /**
     * Constructs the object.
     */
    MinPQ() {
        this(1);
    }
    /**
     * Constructs the object.
     *
     * @param      initCapacity  The initialize capacity
     * @param      comparators   The comparators
     */
    MinPQ(final int initCapacity, final Comparator<Key> comparators) {
        this.comparator = comparators;
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Constructs the object.
     *
     * @param      comparators  The comparators
     */
    MinPQ(final Comparator<Key> comparators) {
        this(1, comparators);
    }

    /**
     * Constructs the object.
     *
     * @param      keys  The keys
     */
    MinPQ(final Key[] keys) {
        n = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for (int i = 0; i < n; i++) {
            pq[i + 1] = keys[i];
        }
        for (int k = n / 2; k >= 1; k--) {
            sink(k);
        }
        assert isMinHeap();
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return n == 0;
    }
    /**
     * returns size.
     *
     * @return    Size.
     */
    public int size() {
        return n;
    }
    /**
     * MIn.
     *
     * @return     { description_of_the_return_value }
     */
    public Key min() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        return pq[1];
    }
    /**
     * Resizes array.
     *
     * @param      capacity  The capacity
     */
    //Complexity - N

    private void resize(final int capacity) {
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    /**
     * Inserts key.
     *
     * @param      x     { parameter_description }
     */
    public void insert(final Key x) {
        if (n == pq.length - 1) {
            resize(2 * pq.length);
        }
        pq[++n] = x;
        swim(n);
        assert isMinHeap();
    }
    /**
     * Deletes Min key.
     *
     * @return     { description_of_the_return_value }
     */
    public Key delMin() {
        if (isEmpty()) {
            throw new NoSuchElementException(
                "Priority queue underflow");
        }
        Key min = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = null;
        final int four = 4;
        if ((n > 0) && (n == (pq.length - 1) / four)) {
            resize(pq.length / 2);
        }
        assert isMinHeap();
        return min;
    }
    /**
     * Changes leaf.
     *
     * @param      ka    { parameter_description }
     */
    //Complexity - N
    private void swim(final int ka) {
        int k = ka;
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }
    /**
     * Sink (root node changes).
     *
     * @param      ka    { parameter_description }
     */
    //Complexity - N
    private void sink(final int ka) {
        int k = ka;
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1)) {
                j++;
            }
            if (!greater(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }
    /**
     * Determines the greater.
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private boolean greater(final int i, final int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        } else {
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }
    /**
     * Exchanges elemets/items.
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    private void exch(final int i, final int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
    /**
     * Determines if minimum heap.
     *
     * @return     True if minimum heap, False otherwise.
     */
    private boolean isMinHeap() {
        return isMinHeap(1);
    }
    /**
     * Determines if minimum heap.
     *
     * @param      k     { parameter_description }
     *
     * @return     True if minimum heap, False otherwise.
     */
    private boolean isMinHeap(final int k) {
        if (k > n) {
            return true;
        }
        int left = 2 * k;
        int right = 2 * k + 1;
        if (left  <= n && greater(k, left)) {
            return false;
        }
        if (right <= n && greater(k, right)) {
            return false;
        }
        return isMinHeap(left) && isMinHeap(right);
    }
    /**
     * Iterator.
     *
     * @return     returns iterator.
     */
    public Iterator<Key> iterator() {
        return new HeapIterator();
    }
    /**
     * Class for heap iterator.
     */
    private class HeapIterator implements Iterator<Key> {
        private MinPQ<Key> copy;
        /**
         * Constructs the object.
         */
        HeapIterator() {
            if (comparator == null) {
                copy = new MinPQ<Key>(size());
            } else {
                copy = new MinPQ<Key>(size(), comparator);
            }
            for (int i = 1; i <= n; i++) {
                copy.insert(pq[i]);
            }
        }
        /**
         * Determines if it has next.
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
            return !copy.isEmpty();
        }
        /**
         * Removes.
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
        /**
         * Next.
         *
         * @return     { description_of_the_return_value }
         */
        public Key next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return copy.delMin();
        }
    }
}

final class Solution {

    private Solution() {
    }
    /**
     * Taxi numbers.
     *
     * @param      list   The list
     * @param      numer  The numer
     * @param      rep    The rep
     *
     * @return     { description_of_the_return_value }
     */
    // COmplexity - N^2
    static int taxinumber(final ArrayList<CubeSum> list,
                          final int numer, final int rep) {
        int num = numer;
        int i = 0;
        int res = 0;
        while (num != 0 && i < list.size() - rep + 1) {
            ArrayList<CubeSum> sub = new ArrayList<CubeSum>(
                list.subList(i++, i + rep - 1));
            HashSet<Integer> set = new HashSet<Integer>();
            for (CubeSum cs : sub) {
                set.add(cs.getsum());
            }
            if (set.size() == 1) {
                res = sub.get(0).getsum();
                num--;
            }
        }
        return res;
    }
    /**
     * Main funtion.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        final int number = 1000;
        Scanner s = new Scanner(System.in);
        ArrayList<CubeSum> cube = new ArrayList<CubeSum>();
        MinPQ<CubeSum> min = new MinPQ<CubeSum>();
        for (int i = 1; i < number; i++) {
            min.insert(new CubeSum(i, i));
        }
        while (!min.isEmpty()) {
            CubeSum cs = min.delMin();
            cube.add(cs);
            if (cs.getj() < number) {
                min.insert(new CubeSum(cs.geti(), cs.getj() + 1));
            }
        }
        int numer = s.nextInt();
        int repeat = s.nextInt();
        System.out.println(taxinumber(cube, numer, repeat));
    }
}
