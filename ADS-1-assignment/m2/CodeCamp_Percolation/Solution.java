import java.util.*;
/**
 * Class for solution.
 */
class Solution {
    /**
     * Constructs the object.
     */
    Solution(){

    }
    /**
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = Integer.parseInt(sc.nextLine());
        percolate obj = new percolate(input);
        while (sc.hasNextLine()) {
            String[] inputs = sc.nextLine().split(" ");
            obj.open(Integer.parseInt(inputs[0]) - 1, Integer.parseInt(inputs[1]) - 1);
        }
        System.out.println(obj.ispercolate());
    }

}
/**
 * Class for percolate.
 */
class percolate {
    /**
     * { boolean grid }.
     */
    boolean[][] grid;
    /**
     * { WeightedQuickUnionUF object }.
     */
    WeightedQuickUnionUF obj;
    /**
     * {  int size }.
     */
    int size;
    /**
     * Constructs the object.
     *
     * @param      size  The size
     */
    percolate(int size) {
        this.size = size;
        grid = new boolean[size][size];
        obj = new WeightedQuickUnionUF(size * size + 2);
    }
    /**
     * { open }.
     *
     * @param      row     The row
     * @param      column  The column
     */
    public void open(int row, int column) {
        if (grid[row][column]) {
            return;
        }
        grid[row][column] = true;
        if (row == 0) {
            obj.union(convert(row, column), size * size);
        }
        if (row == size - 1) {
            obj.union(convert(row, column), size * size + 1);
        }
        if (row < size - 1 && grid[row + 1][column]) { //bottom element
            obj.union(convert(row, column), convert(row + 1, column));
        }
        if (row > 0 && grid[row - 1][column]) { //top element
            obj.union(convert(row, column), convert(row - 1, column));
        }
        if (column > 0 && grid[row][column - 1]) { //left element
            obj.union(convert(row, column), convert(row, column - 1));
        }
        if (column < size - 1 && grid[row][column + 1]) { //right element
            obj.union(convert(row, column), convert(row, column + 1));
        }


    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public boolean ispercolate() {
        return obj.connected(size * size, size * size + 1);
    }
    /**
     * { function_description }.
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int convert(final int i,final int j) {
        return i * size + j;
    }
}
