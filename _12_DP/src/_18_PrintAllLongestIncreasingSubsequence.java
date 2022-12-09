public class _18_PrintAllLongestIncreasingSubsequence {
}
    Q.  Print All Longest Increasing Subsequence
        -----------------------------------------------
        Given an array with N elements, you need to find the length of the longest subsequence in the given array such that all elements of the subsequence are sorted in strictly increasing order. And then Print All Longest Increasing Subsequence.
        -----------------------------------------------
        Input Format
        The first line of input contains an integer N. The following line contains N space separated integers, that denote the value of elements of array.
        Output Format
        The first and only line of output contains the length of longest subsequence.
        -----------------------------------------------
        Create Project: Dynamic Programming

        Create Package: default

Create class: PrintAllLongestIncreasingSubsequence
        -----------------------------------------------
public class PrintAllLongestIncreasingSubsequence {

    public static class Pair {
        int length;
        int index;
        int value;
        String pathSoFar;

        Pair(int length, int index, int value, String pathSoFar){
            this.length = length;
            this.index = index;
            this.value = value;
            this.pathSoFar = pathSoFar;
        }
    }

    public static void printLis(int arr[]) {
        int overAllMax = 0;
        int[] dp = new int[arr.length];
        for (int i = 0; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (dp[j] > max) {
                        max = dp[j];
                    }
                }
            }
            dp[i] = max + 1;
            if (dp[i] > overAllMax) {
                overAllMax = dp[i];
            }
        }

        System.out.println(overAllMax);

        ArrayDeque<Pair> queue = new ArrayDeque<>();
        for (int i = 0; i < dp.length; i++) {
            if (overAllMax == dp[i]) {
                queue.add(new Pair(overAllMax, i, arr[i], arr[i] + ""));
            }
        }

        while (queue.size() > 0) {
            Pair remove = queue.removeFirst();

            if (remove.length == 1) {
                System.out.println(remove.pathSoFar);
            }

            for (int j = 0; j < remove.index; j++) {
                if (dp[j] == remove.length - 1 && arr[j] <= remove.value) {
                    queue.add(new Pair(dp[j], j, arr[j], arr[j] + " -> " + remove.pathSoFar));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        printLis(arr);
    }
}
-------------------------------------------------
        Input:
        10
        10 22 43 33 21 50 41 60 59 3

        Output:
        5
        10 -> 22 -> 43 -> 50 -> 60
        10 -> 22 -> 33 -> 50 -> 60
        10 -> 22 -> 33 -> 41 -> 60
        10 -> 22 -> 43 -> 50 -> 59
        10 -> 22 -> 33 -> 50 -> 59
        10 -> 22 -> 33 -> 41 -> 59
        ------------------------------
        Input:
        10
        10 22 42 33 21 50 41 60 80 3

        Output:
        6
        10 -> 22 -> 42 -> 50 -> 60 -> 80
        10 -> 22 -> 33 -> 50 -> 60 -> 80
        10 -> 22 -> 33 -> 41 -> 60 -> 80