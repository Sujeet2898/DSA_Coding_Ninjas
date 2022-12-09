public class _5_NumberOfBalancedBTs {
}
Q.  Code: Number of Balanced BTs
        -----------------------------------------------
        Given an integer h, find the possible number of balanced binary trees of height h. You just need to return the count of possible binary trees which are balanced.
        This number can be huge, so, return output modulus 10^9 + 7.
        Time complexity should be O(h).
        -----------------------------------------------
        Create Project: Dynamic Programming

        Create Package: default

Create class: MinimumCountOfSquares
        -----------------------------------------------
public class MinimumCountOfSquares {

    /*   Time Complexity: O(2^h)    */

    public static int countBalancedBTs(int h){

        // BaseCase
        if (h == 0 || h == 1){
            return 1;
        }

        // Work using recursion
        int mod = (int)Math.pow(10, 9) + 7;

        int x = countBalancedBTs(h - 1);
        int y = countBalancedBTs(h - 2);

        long result1 = (long)x * x;
        long result2 = (long)x * y * 2;
        int value1 = (int)(result1 % mod);
        int value2 = (int)(result2 % mod);

        return (value1 + value2) % mod;
    }

    /*                OR
    public static long countBalancedBTs(long h){
        if (h == 0 || h == 1){
            return 1;
        }
        long mod = (long)Math.pow(10, 9) + 7;
        long x = countBalancedBTs(h - 1);
        long y = countBalancedBTs(h - 2);
        return (x*x + 2*x*y) % mod;
    }
    */

    /*   Time Complexity: O(h) by using Memoization Technique    */

    public static int countBalancedBTsM(int h){
        // Making storageArray of n+1 size
        int[] storage = new int[h+1];

        // recursive call
        return countBalancedBTsM(h,storage);
    }

    // Private function for storing result (only unique result to avoid redundancy)
    private static int countBalancedBTsM(int h, int[] storage) {

        // BaseCase
        if(h==0 || h==1) {
            storage[h] = 1;
            return storage[h];
        }

        // Checking already calculated value
        if(storage[h]!=0) {
            return storage[h];
        }

        //  Work
        int mod = (int)Math.pow(10, 9) + 7;

        int x = countBalancedBTsM(h - 1, storage);
        int y = countBalancedBTsM(h - 2, storage);

        long result1 = (long)x * x;
        long result2 = (long)x * y * 2;
        int value1 = (int)(result1 % mod);
        int value2 = (int)(result2 % mod);

        // Storing the newly calculated value in the array to avoid repetition
        storage[h] = (value1 + value2) % mod;
        return storage[h];
    }

    /*   Time Complexity: O(h) by using Dynamic Programming  */

    public static int countBalancedBTsDP(int h){
        int mod = (int)Math.pow(10, 9) + 7;

        // Our target is to store result in a storageArray
        int[] storage  = new int[h + 1];

        // Entry corresponding to baseCase
        storage[0]=1;
        storage[1]=1;

        // "for" loop for next entries
        for(int i=2;i<=h;i++){

            int x = storage[i - 1];
            int y = storage[i - 2];

            long result1 = (long)x * x;
            long result2 = (long)x * y * 2;
            int value1 = (int)(result1 % mod);
            int value2 = (int)(result2 % mod);

            storage[i] = (value1 + value2) % mod;
        }
        return storage[h];
    }

    public static void main(String[] args) {
        int h = 9;
        System.out.println(countBalancedBTsDP(h));

        System.out.println();

        System.out.println(countBalancedBTsM(h));

        System.out.println();

        System.out.println(countBalancedBTs(h));
    }
}
--------------------------------------------
        Output:
        236726334           // Quickly run

        236726334           // Quickly run

        236726334           // Take time in running