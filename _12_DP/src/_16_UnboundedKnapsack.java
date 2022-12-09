public class _16_UnboundedKnapsack {
}
Q.  Code: Unbounded Knapsack  (Duplicacy allowed)
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

Create class: UnboundedKnapsack
        -----------------------------------------------
public class UnboundedKnapsack {

    public static int UnboundedKnapsack(int[] weights, int[] values, int n, int maxWeight){
        int[] dp = new int[maxWeight + 1];

        // for no transaction
        dp[0] = 0;

        // Outer loop is for the maxWeight
        for (int i = 1; i <= maxWeight; i++){

            // Inner loop is for specific weight of outer loop
            int max = 0;
            for (int j = 0; j < n; j++){
                if (weights[j] <= i) {
                    int temp = dp[i - weights[j]] + values[j];

                    if (temp > max){
                        max = temp;
                    }
                }
            }
            dp[i] = max;
        }
        return dp[maxWeight];
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
        System.out.println(UnboundedKnapsack(weights,values,n,maxWeight));
    }
}
------------------------------------------------
        Input:
        5
        2 5 1 3 4
        15 14 10 45 30
        7
        Output:
        100
