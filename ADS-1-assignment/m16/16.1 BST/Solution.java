import java.util.Scanner;
/**
 * Class for book.
 */
class Book implements Comparable<Book> {
    /**
     * { var_description }
     */
    private String name;
    /**
     * { var_description }
     */
    private String author;
    /**
     * { var_description }
     */
    private double price;
    /**
     * Constructs the object.
     *
     * @param      bookName    The book name
     * @param      authorName  The author name
     * @param      cost        The cost
     */
    Book(final String bookName, final String authorName,
         final double cost) {
        this.name = bookName;
        this.author = authorName;
        this.price = cost;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * { function_description }
     *
     * @param      obj   The object
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Book obj) {
        return this.getName().compareTo(obj.getName());
    }
}
/**
 * Class for binary search t.
 *
 * @param      <Key>     The key
 * @param      <Values>  The values
 */
class BinarySearchT<Key extends Comparable<Key>, Values> {
    /**
     * { var_description }
     */
    private Node root;
    /**
     * Class for node.
     */
    class Node {
        private Key key;
        private Values value;
        private Node right;
        private Node left;
        Node(final Key key1, final Values val) {
            this.key = key1;
            this.value = val;
        }

    }
    /**
     * { function_description }
     *
     * @param      key    The key
     * @param      value  The value
     */
    public void put(final Key key, final Values value) {
        if (key == null) {
            return;
        }
        root = put(root, key, value);
    }
    /**
     * { function_description }
     *
     * @param      node   The node
     * @param      key    The key
     * @param      value  The value
     *
     * @return     { description_of_the_return_value }
     */
    public Node put(final Node node, final Key key,
                    final Values value) {
        if (node == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    public Values get(final Key key) {
        return get(root, key);
    }
    /**
     * { function_description }
     *
     * @param      node  The node
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    private Values get(final Node node, final Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node.value;
        }
    }
}
/**
 * { item_description }
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        BinarySearchT<Book, Integer> obj = new BinarySearchT<>();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            switch (tokens[0]) {
            case "put":
                obj.put(new Book(tokens[1], tokens[2], Double.parseDouble(
                                     tokens[2 + 1])),
                        Integer.parseInt(tokens[2 + 2]));
                break;
            case "get":
                System.out.println(obj.get(new Book(
                                               tokens[1], tokens[2],
                                               Double.parseDouble(
                                                   tokens[2 + 1]))));
                break;
            default:
                break;
            }
        }
    }
}
