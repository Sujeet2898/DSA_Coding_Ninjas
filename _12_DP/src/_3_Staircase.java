public class _3_Staircase {
}
Q.  Code: Staircase
        -----------------------------------------------
        A child runs up a staircase with 'n' steps and can hop either 1 step, 2 steps or 3 steps at a time. Implement a method to count and return all possible ways in which the child can run-up to the stairs.
        -----------------------------------------------
        Create Project: Dynamic Programming

        Create Package: default

Create class: Staircase
        -----------------------------------------------
public class Staircase {

    /*   Time Complexity: O(2^n)    */

    public static long staircase(int n){
        if(n==0) {
            return 1;
        }
        if(n==1) {
            return 1;
        }
        if(n==2) {
            return 2;
        }
        return staircase(n-1) + staircase(n-2) + staircase(n-3);
    }

    /*   Time Complexity: O(n) by using Memoization Technique    */

    public static long staircaseM(int n){

        // Making storageArray of n+1 size
        long storage[] = new long[n+1];

        // recursive call
        return staircaseM(n, storage);
    }

    // Private function for storing result (only unique result to avoid redundancy)

    private static long staircaseM(int n, long[] storage){

        // BaseCase
        if (n == 0){
            storage[n] = 1;
            return storage[n];
        }

        if (n == 1 || n == 2){
            storage[n] = n;
            return storage[n];
        }

        // Checking already calculated value
        if (storage[n] != 0){
            return storage[n];
        }

        // Storing the newly calculated value in the array to avoid repetition
        storage[n] = staircaseM(n - 1, storage) + staircaseM(n - 2, storage) + staircaseM(n - 3, storage);
        return storage[n];
    }

   /*   Time Complexity: O(n) by using Dynamic Programming

   public static long staircaseDP(int n) {

       // for no. of stair 0, 1 & 2
        if(n==0) {
            return 1;
        }
        if(n==1) {
            return 1;
        }
        if(n==2) {
            return 2;
        }

        // Our target is to store result in a storageArray
        long storage[] = new long[n+1];

        // Entry corresponding to baseCase
        storage[1] = 0;
        storage[0] = 1;
        storage[1] = 1;
        storage[2] = 2;

        // "for" loop for next entries
        for(int i=3;i<=n;i++) {
            storage[i] = storage[i-1] + storage[i-2] + storage[i-3];
        }

        return storage[n];
    }

   public static void main(String[] args) {
        int n = 10;
        System.out.println(staircaseDP(n));
        System.out.println();
        System.out.println(staircaseM(n));
        System.out.println();
        System.out.println(staircase(n));
    }
  }
  ------------------------------------------
  Output:
  274

  274

  274