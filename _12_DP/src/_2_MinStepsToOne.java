public class _2_MinStepsToOne {
}
Q.  Code: Min Steps to One
        ------------------------------------------------
        Given a positive integer 'n', find and return the minimum number of steps that 'n' has to take to get reduced to 1. You can perform any one of the following 3 steps:
        1.) Subtract 1 from it. (n = n - 1) ,
        2.) If n is divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
        3.) If n is divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).
        ------------------------------------------------
        Create Project: Dynamic Programming

        Create Package: default

Create class: TakeNumberToOne
        -----------------------------------------------
public class TakeNumberToOne {

    /*   Time Complexity: O(2^n)    */

    public static int countSteps(int n){
        if (n == 1){
            return 0;
        }

        // Three options for approaching to 1
        int op1 = countSteps(n - 1);
        int minSteps = op1;
        if (n % 3 == 0){
            int op2 = countSteps(n / 3);
            if (op2 < minSteps){
                minSteps = op2;
            }
        }
        if (n % 2 == 0){
            int op3 = countSteps(n / 2);
            if (op3 < minSteps){
                minSteps = op3;
            }
        }
        return 1 + minSteps;
    }

    /*   Time Complexity: O(n) by using Memoization Technique    */

    public static int countStepsM(int n){

        // Making storageArray of n+1 size
        int storage[] = new int[n + 1];

        // recursive call
        return countStepsM(n, storage);
    }

    // Private function for storing result (only unique result to avoid redundancy)

    private static int countStepsM(int n, int[] storage){

        // BaseCase
        if (n == 1){
            storage[n] = 0;
            return storage[n];
        }

        // Checking already calculated value
        if (storage[n] != 0){
            return storage[n];
        }

        // Three options for approaching to 1
        int op1 = countStepsM(n - 1, storage);
        int minSteps = op1;
        if (n % 3 == 0){
            int op2 = countStepsM(n / 3, storage);
            if (op2 < minSteps){
                minSteps = op2;
            }
        }
        if (n % 2 == 0){
            int op3 = countStepsM(n / 2, storage);
            if (op3 < minSteps){
                minSteps = op3;
            }
        }

        // Storing the newly calculated value in the array to avoid repetition
        storage[n] = 1 + minSteps;
        return storage[n];
    }

    /*   Time Complexity: O(n) by using Dynamic Programming  */

    public static int countStepsDP(int n){

        // Our target is to store result in a storageArray
        int storage[] = new int[n + 1];

        // Entry corresponding to baseCase
        storage[1] = 0;

        // "for" loop for next entries
        for (int i = 2; i <= n; i++){

            // Three options for approaching to 1
            int op1 = storage[i - 1];
            int minSteps = op1;
            if (i % 3 == 0){
                int op2 = storage[i / 3];
                if (op2 < minSteps){
                    minSteps = op2;
                }
            }
            if (i % 2 == 0){
                int op3 = storage[i / 2];
                if (op3 < minSteps){
                    minSteps = op3;
                }
            }
            storage[i] = 1 + minSteps;
        }
        return storage[n];
    }

    public static void main(String[] args) {
        int n = 500;
        System.out.println(countStepsDP(n));

        System.out.println();

        System.out.println(countStepsM(n));

        System.out.println();

        System.out.println(countSteps(n));
    }
}
--------------------------------------------
        Output:
        9          // Quickly run

        9          // Quickly run

        9          // Take time in running