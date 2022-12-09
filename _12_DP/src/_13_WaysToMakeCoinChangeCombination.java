public class _13_WaysToMakeCoinChangeCombination {
}
    Q.  Ways To Make Coin Change (Combination) (Duplicacy allowed)
        -----------------------------------------------
        For the given infinite supply of coins of each of denominations, D = {D0, D1, D2, D3, ...... Dn-1}. You need to figure out the total number of ways W, in which you can make the change for Value V using coins of denominations D.
        Return 0 if the change isn't possible.
        -----------------------------------------------
        Create Project: Dynamic Programming

        Create Package: default

Create class: WaysToMakeCoinChangeC
        -----------------------------------------------
public class WaysToMakeCoinChangeC {

    public static int countWaysToMakeChange(int denominations[], int value){
        int[] dp = new int[value + 1];

        // for no transaction
        dp[0] = 1;

        // Outer loop is for the coins so that we can form combination
        for (int i = 0; i < denominations.length; i++){

            // Inner loop is for specific coin of outer loop and proceed onwards from this particular coin
            for (int j = denominations[i]; j < dp.length; j++){
                dp[j] += dp[j - denominations[i]];
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
        2

        Number of ways are -> 2 total i.e. (2,5) and (2,2,3).

        -------------------------
        Input:
        3
        1 2 3
        4
        Output:
        4

        Number of ways are -> 4 total i.e. (1,1,1,1), (1,1, 2), (1, 3) and (2, 2).
        ------------------------
        Input:
        6
        1 2 3 4 5 6
        250
        Output:
        13868903