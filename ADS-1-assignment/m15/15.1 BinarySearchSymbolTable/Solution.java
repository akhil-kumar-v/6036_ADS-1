
import java.util.Scanner;

import java.util.ArrayList;
/**
 * Class for binarysearch st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BinarysearchST<Key extends Comparable<Key>, Value> {
    /**
     * Key arr.
     */
    private Key[] keys;
    /**
     * Value arr.
     */
    private Value[] vals;
    /**
     * int size.
     */
    private int size;
    /**
     * Constructs the object.
     */
    BinarysearchST() {
    }
    /**
     * Constructs the object.
     *
     * @param      capacity  The capacity
     */
    BinarysearchST(final int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }
    /**
     * Resize.
     *
     * @param      capacity  The capacity
     */
    public void resize(final int capacity) {
        Key[] tempkey = (Key[]) new Comparable[capacity];
        Value[] tempval = (Value[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            tempkey[i] = keys[i];
            tempval[i] = vals[i];
        }

        vals = tempval;
        keys = tempkey;
    }
    /**
     * to return size.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size;
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
     * Contains.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final Key key) {
        return get(key) != null;
    }
    /**
     * Get.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Value get(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key is null");
        }

        if (isEmpty()) {
            return null;
        }

        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0) {
            return vals[i];
        }
        return null;
    }
    /**
     * Int rank.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public int rank(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to rank() is null");
        }

        int low = 0; int high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comp = key.compareTo(keys[mid]);
            if (comp < 0) {
                high = mid - 1;
            } else if (comp > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }
    /**
     * Inserting.
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Key key, final Value val) {
        if (key == null) {
            throw new IllegalArgumentException("Null key");
        }

        if (val == null) {
            delete(key);
            return;
        }

        int i = rank(key);

        if (i < size && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }

        if (size == keys.length) {
            resize(2 * keys.length);
        }

        for (int j = size; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }

        keys[i] = key;
        vals[i] = val;
        size++;
    }

    /**
     * Delete.
     *
     * @param      key   The key
     */
    public void delete(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to delete() is null");
        }

        if (isEmpty()) {
            return;
        }

        int i = rank(key);

        if (i == size || keys[i].compareTo(key) != 0) {
            return;
        }

        for (int j = i; j < size - 1; j++) {
            keys[j] = keys[j + 1];
            vals[j] = vals[j + 1];
        }

        size--;
        keys[size] = null;
        vals[size] = null;

        if (size > 0 && size == keys.length / (2 + 2)) {
            resize(keys.length / 2);
        }
    }
    /**
     * Select.
     *
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Key select(final int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("Invalid argument");
        }

        return keys[k];
    }
    /**
     * Flooring.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Key floor(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to floor() is null");
        }
        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0) {
            return keys[i];
        }
        if (i == 0) {
            return null;
        } else {
            return keys[i - 1];
        }
    }
    /**
     * Ceiling.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Key ceiling(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to ceiling() is null");
        }
        int i = rank(key);
        if (i == size) {
            return null;
        } else {
            return keys[i];
        }
    }
    /**
     * Array list Keys.
     *
     * @return     { description_of_the_return_value }
     */
    public ArrayList<String> keys() {
        return keys(min(), max());
    }
    /**
     * Get min.
     *
     * @return     { description_of_the_return_value }
     */
    public Key min() {
        return keys[0];
    }
    /**
     * Get max.
     *
     * @return     { description_of_the_return_value }
     */
    public Key max() {
        return keys[size - 1];
    }
    /**
     * DeleteMin.
     */
    public void deleteMin() {
        delete(min());
    }
    /**
     * keys.
     *
     * @param      low   The low
     * @param      high  The high
     *
     * @return     Arraylist
     */
    public ArrayList<String> keys(final Key low, final Key high) {
        if (low == null) {
            throw new
            IllegalArgumentException("first argument to keys() is null");
        }

        if (high == null) {
            throw new
            IllegalArgumentException("last argument to keys() is null");
        }

        ArrayList<String> limit = new ArrayList<>();
        if (low.compareTo(high) > 0) {
            return limit;
        }

        for (int i = rank(low); i < rank(high); i++) {
            limit.add((String) keys[i]);
        }

        if (contains(high)) {
            limit.add((String) keys[rank(high)]);
        }

        return limit;
    }


}

/**
 * Class for solution.
 */
final class Solution {
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
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarysearchST<String, Integer> bst = new
        BinarysearchST<String, Integer>();
        String[] input = sc.nextLine().split(" ");
        bst = new BinarysearchST<String, Integer>(input.length);
        for (int i = 0; i < input.length; i++) {
            bst.put(input[i], i);
        }
        while (sc.hasNextLine()) {
            String[] tokens = sc.nextLine().split(" ");
            switch (tokens[0]) {
            case "contains":
                System.out.println(bst.contains(tokens[1]));
                break;
            case "get":
                System.out.println(bst.get(tokens[1]));
                break;
            case "max":
                System.out.println(bst.max());
                break;
            case "min":
                System.out.println(bst.min());
                break;
            case "floor":
                System.out.println(bst.floor(tokens[1]));
                break;
            case "rank":
                System.out.println(bst.rank(tokens[1]));
                break;
            case "deleteMin":
                bst.deleteMin();
                break;
            case "keys":
                ArrayList<String> limit = bst.keys();
                for (int i = 0; i < limit.size(); i++) {
                    System.out.println(limit.get(i) + " "
                                       + bst.get(limit.get(i)));
                }
                break;
            default:
                break;
            }
        }
    }
}


