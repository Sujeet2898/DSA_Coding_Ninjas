public class _14_WaysToMakeCoinChangePermutation {
}
    Q.  Ways To Make Coin Change (Permutation)  (Duplicacy allowed)
        -----------------------------------------------
        For the given infinite supply of coins of each of denominations, D = {D0, D1, D2, D3, ...... Dn-1}. You need to figure out the total number of ways W, in which you can make the change for Value V using coins of denominations D.
        Return 0 if the change isn't possible.
        -----------------------------------------------
        Create Project: Dynamic Programming

        Create Package: default

Create class: WaysToMakeCoinChangeP
        -----------------------------------------------
public class WaysToMakeCoinChangeP {

    public static int countWaysToMakeChangeP(int denominations[], int value){
        int[] dp = new int[value + 1];

        // for no transaction
        dp[0] = 1;

        // Outer loop to form permutation
        for (int i = 1; i < dp.length; i++){

            // Inner loop is for specific coin of outer loop
            for (int j = 0; j < denominations.length; j++){
                if (denominations[j] <= i) {
                    dp[i] += dp[i - denominations[j]];
                }
            }
        }
        return dp[value];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        int value = scn.nextInt();
        System.out.println(countWaysToMakeChange(arr,value));
    }
}
------------------------------------------------
        Input:
        3
        2 3 5
        7
        Output:
        5

        Number of ways are -> 5 total i.e. (2,5), (5,2), (2,2,3), (2,3,2) and (3,2,2).