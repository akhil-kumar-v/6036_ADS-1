
import java.util.Scanner;

import java.util.ArrayList;

class BinarysearchST<Key extends Comparable<Key>, Value> {

    private Key[] keys;

    private Value[] vals;

    private int size;

    BinarysearchST() {
    }

    BinarysearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public void resize(int capacity) {
        Key[] tempkey = (Key[]) new Comparable[capacity];
        Value[] tempval = (Value[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            tempkey[i] = keys[i];
            tempval[i] = vals[i];
        }

        vals = tempval;
        keys = tempkey;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) {
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

    public int rank(Key key) {
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

    public void put(Key key, Value val) {
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


    public void delete(Key key) {
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

    public Key select(int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("Invalid argument");
        }

        return keys[k];
    }

    public Key floor(Key key) {
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

    public Key ceiling(Key key) {
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

    public ArrayList<String> keys() {
        return keys(min(), max());
    }

    public Key min() {


        return keys[0];
    }

    public Key max() {


        return keys[size - 1];
    }

    public void deleteMin() {
        delete(min());
    }

    public ArrayList<String> keys(Key low, Key high) {
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


class Solution {

    private Solution() {
    }
    public static void main(String[] args) {
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


