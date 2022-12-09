public class _12_SubsetSum {
}
    Q.  Subset Sum (Duplicacy not allowed)
-----------------------------------------------
        You are given a set of N integers. You have to return true if there exists a subset that sum up to K, otherwise return false.
        -----------------------------------------------
        Create Project: Dynamic Programming

        Create Package: default

Create class: SubsetSum
        -----------------------------------------------
        Dynamic Programming steps:
        1. Storage & Meaning
        2. Direction
        3. Travel & Solve
        -----------------------------------------------
public class SubsetSum {

    static boolean isSubsetPresent(int[] arr, int n, int sum){

        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i < dp.length; i++){
            for (int j = 0; j < dp[0].length; j++){

                // Case 1: First cell
                if (i == 0 && j == 0){
                    dp[i][j] = true;

                    // Case 2: All cells of First row
                }else if (i == 0){
                    dp[i][j] = false;

                    // Case 3: All cells of First column
                }else if (j == 0){
                    dp[i][j] = true;

                    // Case 4: Remaining cells has two case
                }else{

                    // Case 1: Not included, look exactly upward
                    if (dp[i - 1][j] == true){
                        dp[i][j] = true;

                        // Case 2: Included
                    }else {

                        // ith index of dp is aligned with (i - 1)th index
                        int val = arr[i - 1];

                        // included only if jth tagetSum is greater than value at (i - 1)th index
                        if (j >= val){

                            // look exactly at j-val
                            if (dp[i - 1][j - val] == true){
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }
        return dp[arr.length][sum];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        int targetSum = scn.nextInt();  // here, targetSum is sum
        System.out.println(isSubsetPresent(arr,n,targetSum));
    }
}
--------------------------------------------
        Input:
        4
        4 3 5 2
        13
        Output:
        false
        --------------------------------------------
        Input:
        5
        4 2 5 6 7
        14
        Output:
        true