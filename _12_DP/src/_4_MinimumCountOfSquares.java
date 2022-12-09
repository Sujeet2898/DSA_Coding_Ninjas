public class _4_MinimumCountOfSquares {
}
Q.  Code: Minimum Count of Squares
        -----------------------------------------------
        Given an integer N, find and return the count of minimum numbers required to represent N as a sum of squares.
        That is, if N is 4, then we can represent it as : {1^2 + 1^2 + 1^2 + 1^2} and {2^2}. The output will be 1, as 1 is the minimum count of numbers required to represent N as sum of squares.
        -----------------------------------------------
        Create Project: Dynamic Programming

        Create Package: default

Create class: MinimumCountOfSquares
        -----------------------------------------------
public class MinimumCountOfSquares {

    /*   Time Complexity: O(2^n)    */

    public static int minCount(int n) {

        // BaseCase
        if(n==1) {
            return 1;
        }
        if(n==0) {
            return 0;
        }

        // Work
        int min =Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++) {
            int count = minCount( n - (i*i));
            if(min > count ) {
                min = count;
            }
        }
        return min + 1;
    }

    /*   Time Complexity: O(n) by using Memoization Technique    */

    public static int minCountM(int n) {

        // Making storageArray of n+1 size
        int[] storage = new int[n+1];

        // recursive call
        return minCountM(n,storage);
    }

    // Private function for storing result (only unique result to avoid redundancy)
    private static int minCountM(int n,int[] storage) {

        // BaseCase
        if(n==0 || n==1) {
            storage[n] = n;
            return storage[n];
        }

        // Checking already calculated value
        if(storage[n]!=0) {
            return storage[n];
        }

        // Work
        int min= Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++) {
            int count = minCountM(n-(i*i), storage);
            if(min>count)
                min=count;
        }

        // Storing the newly calculated value in the array to avoid repetition
        storage[n] = min + 1;
        return storage[n];
    }

    /*   Time Complexity: O(n) by using Dynamic Programming   */

    public static int minCountDP(int n) {

        // Our target is to store result in a storageArray
        int[] storage  = new int[n+1];

        // Entry corresponding to baseCase
        storage[0]=0;
        storage[1] =1;

        // "for" loop for next entries
        for(int i=2;i<=n;i++) {

            //  Work
            int min = Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++) {
                int count = storage[i-(j*j)];
                if(min > count) {
                    min = count;
                }
            }
            storage[i] = min + 1;
        }
        return storage[n];
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(minCountDP(n));

        System.out.println();

        System.out.println(minCountM(n));

        System.out.println();

        System.out.println(minCount(n));
    }
}
--------------------------------------------
        Output:
        3          // Quickly run

        3          // Quickly run

        3          // Take time in running