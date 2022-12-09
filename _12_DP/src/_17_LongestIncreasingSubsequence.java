public class _17_LongestIncreasingSubsequence {
}
    Q.  Longest Increasing Subsequence
        -----------------------------------------------
        Given an array with N elements, you need to find the length of the longest subsequence in the given array such that all elements of the subsequence are sorted in strictly increasing order.
        -----------------------------------------------
        Input Format
        The first line of input contains an integer N. The following line contains N space separated integers, that denote the value of elements of array.
        Output Format
        The first and only line of output contains the length of longest subsequence.
        -----------------------------------------------
        Create Project: Dynamic Programming

        Create Package: default

Create class: LongestIncreasingSubsequence
        -----------------------------------------------
public class LongestIncreasingSubsequence {

    public static int lis(int arr[]){
        int overAllMax = 0;
        int[] dp = new int[arr.length];
        for (int i = 0; i < dp.length; i++){
            int max = 0;
            for (int j = 0; j < i; j++){
                if (arr[j] < arr[i]) {
                    if (dp[j] > max) {
                        max = dp[j];
                    }
                }
            }
            dp[i] = max + 1;
            if (dp[i] > overAllMax){
                overAllMax = dp[i];
            }
        }
        return overAllMax;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(lis(arr));
    }
}
-------------------------------------------------
        Input:
        6
        5 4 11 1 16 8
        Output:
        3

        Input:
        3
        1 2 2
        Output:
        2
