public class _9_MinimumCostPath {
}
Q.  Code : Minimum Cost Path
        -----------------------------------------------
        An integer matrix of size (M x N) has been given. Find out the minimum cost to reach from the cell (0, 0) to (M - 1, N - 1).
        From a cell (i, j), you can move in three directions:
        1. ((i + 1),  j) which is, "down"
        2. (i, (j + 1)) which is, "to the right"
        3. ((i+1), (j+1)) which is, "to the diagonal"
        The cost of a path is defined as the sum of each cell's values through which the route passes.
        -----------------------------------------------
        Create Project: Dynamic Programming

        Create Package: default

Create class: MinimumCostPath
        -----------------------------------------------
public class MinimumCostPath {

    /*   Time Complexity: O(2^n)    */

    public static int minCostPath(int arr[][]) {

        // we want path from 0 to end
        return minCostPath(arr, 0, 0);
    }

    // Min Cost Path from cell (i, j) to cell (m - 1, n - 1)
    private static int minCostPath(int[][] arr, int i, int j) {
        int m = arr.length;
        int n = arr[0].length;

        // BaseCase
        // You are at the destination cell (last cell)
        if (i == m - 1 && j == n - 1) {
            return arr[i][j];
        }

        // Checking range for the cells of last row and last column
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }

        // Recursive approach for 3 options
        int op1 = minCostPath(arr, i, j + 1);
        int op2 = minCostPath(arr, i + 1, j + 1);
        int op3 = minCostPath(arr, i + 1, j);

        // Adding first cell with minCostPath
        return arr[i][j] + Math.min(op1, Math.min(op2, op3));
    }

    /*   Time Complexity: O(n) by using Memoization Technique    */

    public static int minCostPathM(int arr[][]){
        int m = arr.length;
        int n = arr[0].length;

        // Making storageArray of m rows & n columns size
        int storage[][] = new int[m][n];

        // Initially storageArray is empty
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                storage[i][j] = -1;
            }
        }

        // recursive call for getting path from 0 to end
        return minCostPathM(arr,0,0,storage);
    }

    // Private function for storing result (only unique result to avoid redundancy)
    private static int minCostPathM(int[][] arr, int i, int j, int[][] storage){
        int m = arr.length;
        int n = arr[0].length;

        // BaseCase
        // You are at the destination cell (last cell)
        if (i == m - 1 && j == n - 1) {
            storage[m - 1][n - 1] = arr[i][j];
            return storage[i][j];
        }

        // Checking range for the cells of last row and last column
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }

        // Checking already calculated value
        if (storage[i][j] != -1){
            return storage[i][j];
        }

        // Recursive approach for 3 options
        int op1 = minCostPathM(arr, i, j + 1, storage);
        int op2 = minCostPathM(arr, i + 1, j + 1, storage);
        int op3 = minCostPathM(arr, i + 1, j, storage);

        // Storing the newly calculated value in the array to avoid repetition
        storage[i][j] = arr[i][j] + Math.min(op1, Math.min(op2, op3));
        return storage[i][j];
    }

    /*   Time Complexity: O(n) by using Dynamic Programming  */

    public static int minCostPathDP(int arr[][]){
        int m = arr.length;
        int n = arr[0].length;

        // Our target is to store result in a storageArray
        int storage[][] = new int[m][n];

        // Entry corresponding to baseCase
        // You are at the destination cell (last cell)
        storage[m - 1][n - 1] = arr[m - 1][n - 1];

        // "for" loop for next entries of Last Row [m - 1][j] except last cell
        // Decreasing the column of last row
        for (int j = n - 2; j >= 0; j--){
            storage[m - 1][j] = storage[m - 1][j + 1] + arr[m - 1][j];
        }

        // "for" loop for next entries of Last Column [i][n - 1] except last cell
        // Decreasing the row of last column
        for (int i = m - 2; i >= 0; i--){
            storage[i][n - 1] = storage[i + 1][n - 1] + arr[i][n - 1];
        }

        // "for" loop for next entries of remaining cells by storing last cell value with minCostPath
        for (int i = m - 2; i >= 0; i--){
            for (int j = n - 2; j >= 0; j--){
                storage[i][j] = arr[i][j] + Math.min(storage[i][j + 1], Math.min(storage[i + 1][j + 1], storage[i + 1][j]));
            }
        }

        // returning first cell value
        return storage[0][0];
    }

    public static void main(String[] args) {
        int arr[][] = {{1,1,1}, {4,5,2}, {7,8,9}};
        System.out.println(minCostPathDP(arr));
        System.out.println(minCostPathM(arr));
        System.out.println(minCostPath(arr));
    }
}
 ----------------------------------------------
         Output:
         13     // Quickly run
         13     // Quickly run
         13     // Take time in running