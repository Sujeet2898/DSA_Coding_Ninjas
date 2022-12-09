public class _15_01Knapsack {
}
Q.  Code: 0-1 Knapsack  (Duplicacy not allowed)
        ----------------------------------------------
        A thief is robbing a store and can carry a maximal weight of W into his knapsack. There are N items and ith item weighs wi and is of value vi. Considering the constraints of maximum weight that knapsack can carry, you have to find and return the maximum value that thief can generate by stealing items.
        Note
        Space complexity should be O(W).
        ----------------------------------------------
        Input Format :
        The first line contains an integers, that denote the value of N. The following line contains N space separated integers, that denote the values of weight of items. The following line contains N space separated integers, that denote the values associated with the items. The following line contains an integer that denote the value of W. W denotes maximum weight that thief can carry.
        Output Format :
        The first and only line of output contains the maximum value that thief can generate, as described in the task.
        -----------------------------------------------
        Create Project: Dynamic Programming

        Create Package: default

Create class: Knapsack
        -----------------------------------------------
public class Knapsack {

    public static int knapsack(int[] weights, int[] values, int n, int maxWeight){
        int[][] dp = new int[n + 1][maxWeight + 1];
        for (int i = 0; i < dp.length; i++){
            for (int j = 0; j < dp[0].length; j++){

                // Case 1: First cell
                if (i == 0 && j == 0){
                    dp[i][j] = 0;

                    // Case 2: All cells of First row
                }else if (i == 0){
                    dp[i][j] = 0;

                    // Case 3: All cells of First column
                }else if (j == 0){
                    dp[i][j] = 0;

                    // Case 4: Remaining cells has two case
                }else{

                    // ith index of dp is aligned with (i - 1)th index
                    int val = weights[i - 1];

                    // Case 1: Included

                    // included only if jth targetSum is greater than value at (i - 1)th index
                    if (j >= val){

                        // look exactly at j-val
                        if (dp[i - 1][j - val] + values[i - 1] > dp[i - 1][j]){
                            dp[i][j] = dp[i - 1][j - val] + values[i - 1];
                        }else {
                            // Case 2: Not included, look exactly upward
                            dp[i][j] = dp[i - 1][j];
                        }

                    }else {

                        // Case 2: Not included, look exactly upward
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[n][maxWeight];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] weights = new int[n];
        int[] values = new int[n];

        for (int i = 0; i < weights.length; i++){
            weights[i] = scn.nextInt();
        }
        for (int i = 0; i < values.length; i++){
            values[i] = scn.nextInt();
        }
        int maxWeight = scn.nextInt();
        System.out.println(knapsack(weights,values,n,maxWeight));
    }
}
------------------------------------------------
        Input:
        4
        1 2 4 5
        5 4 8 6
        5
        Output:
        13
