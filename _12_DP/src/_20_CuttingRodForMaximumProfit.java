public class _20_CuttingRodForMaximumProfit {
}
    Create Project: Dynamic Programming

        Create Package: default

Create class:  CuttingRodForMaximumProfit
        -----------------------------------------------
public class CuttingRodForMaximumProfit {

    public static int rodCuttingMaxProfit(int[] prices){
        int[] newPrice = new int[prices.length + 1];

        // Refreshing index of prices as newPrices by adding 1
        for (int i = 0; i < prices.length; i++){
            newPrice[i + 1] = prices[i];
        }

        int[] dp = new int[newPrice.length];
        dp[0] = 0;
        dp[1] = newPrice[1];

        for (int i = 2; i < dp.length; i++){

            // Putting original price early
            dp[i] = newPrice[i];

            int leftIndex = 1;
            int rightIndex = i - 1;
            while (leftIndex <= rightIndex){
                if (dp[leftIndex] + dp[rightIndex] > dp[i]){
                    dp[i] = dp[leftIndex] + dp[rightIndex];
                }
                leftIndex++;
                rightIndex--;
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++){
            prices[i] = scn.nextInt();
        }
        System.out.println(rodCuttingMaxProfit(prices));
    }
}
-------------------------------------------------
        Input:
        8
        1 5 8 9 10 17 17 20
        Output:
        22
