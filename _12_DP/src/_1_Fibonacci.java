public class _1_Fibonacci {
}
    Create Project: Dynamic Programming

        Create Package: default

Create class: Fibonacci
        -----------------------------------------------
public class Fibonacci {

    /*   Time Complexity: O(2^n)    */

    public static int fib(int n){
        if (n == 0 || n == 1){
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /*   Time Complexity: O(n) by using Memoization Technique    */

    public static int fibM(int n){

        // Making storageArray of n+1 size
        int storage[] = new int[n+1];

        // Initially storageArray is empty
        for(int i = 0; i <= n; i++){
            storage[i] = -1;
        }

        // recursive call
        return fibM(n, storage);
    }

    // Function for storing result (only unique result to avoid redundancy)
    public static int fibM(int n, int storage[]){

        // BaseCase
        if (n == 0 || n == 1){
            storage[n] = n;
            return storage[n];
        }

        // Checking already calculated value
        if (storage[n] != -1){
            return storage[n];
        }

        // Storing the newly calculated value in the array to avoid repetition
        storage[n] = fibM(n -1, storage) + fibM(n - 2, storage);
        return storage[n];
    }

    /*   Time Complexity: O(n) by using Dynamic Programming

     Dynamic Programming:
     We are avoiding recursion. Instead we are using iterative method.

     Dynamic Programming is valid with following two conditions:
     1. Overlapping Sub-problems: When we are solving same sub-problems again & again, we are using DP to save the redundants work.
     2. Optimal Sub-structure: Can we find the optimal solution of original problem if we have found the best/optimal solution of these sub-problems.

     Difference between Fib Memoization & Fib DP:-
     Fib Memoization: Top Down Approach in which we are finding and using the cellValue whenever we require cellValue.
     Fib DP: Bottom Up Approach: We are simply calculating all the cellValue from 0 to n without recursion.

     */

    public static int fibDP(int n){

        // Our target is to store result in a storageArray
        int storage[] = new int[n + 1];

        // Entries corresponding to baseCase
        storage[0] = 0;
        storage[1] = 1;

        // "for" loop for next entries
        for (int i = 2; i <= n; i++){
            storage[i] = storage[i - 1] + storage[i - 2];
        }

        return storage[n];
    }

    public static void main(String[] args) {
        int n = 44;
        System.out.println(fibDP(n));

        System.out.println();

        System.out.println(fibM(n));

        System.out.println();

        System.out.println(fib(n));
    }
}
--------------------------------------------
        Output:
        701408733            // Quickly run

        701408733            // Quickly run

        701408733            // Take time in running