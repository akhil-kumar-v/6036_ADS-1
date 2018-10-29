import java.util.Scanner;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class for linear probing hash st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class LinearProbingHashST<Key, Value> {
    /**
     * capacity.
     */
    private static final int INIT_CAPACITY = 4;
    /**
     * N.
     */
    private int n;           // number of key-value pairs in the symbol table
    /**
     * m.
     */
    private int m;           // size of linear probing table
    /**
     * keys.
     */
    private Key[] keys;      // the keys
    /**
     * vals.
     */
    private Value[] vals;    // the values

    /**
     * Constructs the object.
     */
    public LinearProbingHashST() {
        this(INIT_CAPACITY);
    }

    /**
     * Constructs the object.
     *
     * @param      capacity  The capacity
     */
    public LinearProbingHashST(final int capacity) {
        m = capacity;
        n = 0;
        keys = (Key[])   new Object[m];
        vals = (Value[]) new Object[m];
    }

    /**
     * size.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return n;
    }

    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * key.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument "
                                               + "to contains() is null");
        }
        return get(key) != null;
    }
    /**
     * hash.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    private int hash(final Key key) {
        final int ele = 11;
        return (ele * key.hashCode()) % m;
    }
    /**
     * capacity.
     *
     * @param      capacity  The capacity
     */
    private void resize(final int capacity) {
        LinearProbingHashST<Key, Value> temp
            = new LinearProbingHashST<Key, Value>(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        m    = temp.m;
    }

    /**
     * put.
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Key key, final Value val) {
        if (key == null) {
            throw new IllegalArgumentException("first "
                                               + "argument to put() is null");
        }

        if (val == null) {
            delete(key);
            return;
        }

        if (n >= m / 2) resize(2 * m);

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }
    /**
     * get.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Value get(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to get() is null");
        }
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m)
            if (keys[i].equals(key)) {
                return vals[i];
            }
        return null;
    }

    /**
     * delete.
     *
     * @param      key   The key
     */
    public void delete(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to delete() is null");
        }
        if (!contains(key)) {
            return;
        }

        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }

        keys[i] = null;
        vals[i] = null;

        i = (i + 1) % m;
        while (keys[i] != null) {
            Key   keyToRehash = keys[i];
            Value valToRehash = vals[i];
            keys[i] = null;
            vals[i] = null;
            n--;
            put(keyToRehash, valToRehash);
            i = (i + 1) % m;
        }

        n--;

        if (n > 0 && n <= m / 8) {
            resize(m / 2);
        }

        assert check();
    }
    /**
     * keys.
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++)
            if (keys[i] != null) {
                queue.enqueue(keys[i]);
            }
        return queue;
    }

    /**
     * check.
     *
     * @return     { description_of_the_return_value }
     */
    private boolean check() {

        if (m < 2 * n) {
            System.err.println("Hash table size m = " + m
                               + "; array size n = " + n);
            return false;
        }

        for (int i = 0; i < m; i++) {
            if (keys[i] == null) {
                continue;
            } else if (get(keys[i]) != vals[i]) {
                System.err.println("get[" + keys[i] + "] = "
                                   + get(keys[i])
                                   + "; vals[i] = " + vals[i]);
                return false;
            }
        }
        return true;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String out = "{";
        if (this.size() != 0) {
            for (Key s : this.keys()) {
                out += s;
                out += ":";
                out += this.get(s);
                out += ", ";
            }
            out = out.substring(0, out.length() - 2) + "}";
            return out;
        } else {
            return out + "}";
        }
    }
}
/**
 * List of .
 *
 * @param      <Item>  The item
 */
class Queue<Item> implements Iterable<Item> {
    /**
     * FIRSR.
     */
    private Node<Item> first;    // beginning of queue
    /**
     * last.
     */
    private Node<Item> last;     // end of queue
    /**
     * n.
     */
    private int n;               // number of elements on queue
    /**
     * Class for node.
     *
     * @param      <Item>  The item
     */
    private static class Node<Item> {
        /**
         * item.
         */
        private Item item;
        /**
         * next.
         */
        private Node<Item> next;
    }
    /**
     * Constructs the object.
     */
    public Queue() {
        first = null;
        last  = null;
        n = 0;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return first == null;
    }
    /**
     * size.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return n;
    }
    /**
     * peek.
     *
     * @return     { description_of_the_return_value }
     */
    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        return first.item;
    }

    /**
     * enqueue.
     *
     * @param      item  The item
     */
    public void enqueue(final Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
        n++;
    }
    /**
     * dequeue.
     *
     * @return     { description_of_the_return_value }
     */
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) {
            last = null;   // to avoid loitering
        }
        return item;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }
    /**
     * iterator.
     *
     * @return     { description_of_the_return_value }
     */
    public Iterator<Item> iterator()  {
        return new ListIterator<Item>(first);
    }
    /**
     * Class for list iterator.
     *
     * @param      <Item>  The item
     */
    private class ListIterator<Item> implements Iterator<Item> {
        /**
         * current.
         */
        private Node<Item> current;
        /**
         * Constructs the object.
         *
         * @param      first  The first
         */
        ListIterator(final Node<Item> first1) {
            current = first1;
        }
        /**
         * Determines if it has next.
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext()  {
            return current != null;
        }
        /**
         * remove.
         */
        public void remove()      {
            throw new UnsupportedOperationException();
        }
        /**
         * next.
         *
         * @return     { description_of_the_return_value }
         */
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}


/**
 * class solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * main.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        LinearProbingHashST<String, Integer> probe =
            new LinearProbingHashST<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split(" ");
            switch (tokens[0]) {
            case "put":
                probe.put(tokens[1],
                          Integer.parseInt(tokens[2]));
                break;
            case "get":
                System.out.println(probe.get(tokens[1]));
                break;
            case "delete":
                probe.delete(tokens[1]);
                break;
            case "display":
                System.out.println(probe);
                break;
            default:
                break;
            }
        }
    }
}
