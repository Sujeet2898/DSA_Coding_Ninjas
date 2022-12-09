public class _10_LeastCommonSubsequence {
}
    Create Project: Dynamic Programming

        Create Package: default

Create class: LeastCommonSubsequence
        -----------------------------------------------
public class LeastCommonSubsequence {

    /*   Time Complexity: Exponential i.e O(2^something), but not exactly O(2^(m+n))    */

    public static int lcs(String s, String t){

        // BaseCase: either of stringLength is 0
        if (s.length() == 0 || t.length() == 0){
            return 0;
        }

        // If stringLength is not 0

        // Comparing first character
        if (s.charAt(0) == t.charAt(0)){

            // Answer will be minimum one + LCS of remaining string
            return 1 + lcs(s.substring(1), t.substring(1));

        }else{

            // If the first character doesn't match, then we have three options

            // Op1: first complete string & second string whose first character is ignored
            int op1 = lcs(s, t.substring(1));

            // Op2: first string whose first character is ignored & second complete string
            int op2 = lcs(s.substring(1), t);

            /* third option is not explicitly considered to be written as Op3 is anyway already included in Op1 & Op2.

            // Op3: first string whose first character is ignored & second string whose first character is ignored
            int op3 = lcs(s.substring(1), t.substring(1));

            return Math.max(op1, Math.max(op2, op3));
             */

            return Math.max(op1, op2);
        }
    }

    /*   Time Complexity: O(m+n) by using Memoization Technique    */

    public static int lcsM(String s, String t){

        // Making storageArray of m+1, n+1 size
        int storage[][] = new int[s.length() + 1][t.length() + 1];

        // Initially storageArray is empty
        for (int i = 0; i < s.length() + 1; i++){
            for (int j = 0; j < t.length() + 1; j++){
                storage[i][j] = -1;
            }
        }

        // recursive call
        return lcsM(s,t,storage);
    }

    // Private function for storing result (only unique result to avoid redundancy)
    private static int lcsM(String s, String t, int[][] storage){
        int m = s.length();
        int n = t.length();

        // BaseCase: either of stringLength is 0
        if (m == 0 || n == 0){
            storage[m][n] = 0;
            return storage[m][n];
        }

        // Checking already calculated value
        if (storage[m][n] != -1){
            return storage[m][n];
        }

        // Comparing first character of both String
        if (s.charAt(0) == t.charAt(0)){

            // Answer will be minimum one + LCS of remaining string
            storage[m][n] = 1 + lcsM(s.substring(1), t.substring(1), storage);

        }else {

            // If the first character doesn't match

            // Op1: first complete string & second string whose first character is ignored
            int op1 = lcsM(s, t.substring(1), storage);

            // Op2: first string whose first character is ignored & second complete string
            int op2 = lcsM(s.substring(1), t, storage);

            // Storing the newly calculated value in the array to avoid repetition
            storage[m][n] = Math.max(op1, op2);
        }
        return storage[m][n];
    }

    /*   Time Complexity: O(n) by using Dynamic Programming  */

    public static int lcsDP(String s, String t){
        int m = s.length();
        int n = t. length();

        // Our target is to store result in a storageArray
        int storage[][] = new int[m+1][n+1];

        // 2 BaseCase:

        // Entry corresponding to first column
        for (int i = 0; i <= m; i++){
            storage[i][0] = 0;
        }

        // Entry corresponding to first row
        for (int j = 0; j <= n; j++){
            storage[0][j] = 0;
        }

        // "double for" loop for next entries of remaining cells
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){

                // Comparing ith character from last of 1st String & jth character from last of 2nd String because characters are removed from starting
                if (s.charAt(m - i) == t.charAt(n - j)){

                    // Answer will be minimum one + LCS of remaining string
                    storage[i][j] = 1 + storage[i - 1][j - 1];

                }else{

                    // If the last character doesn't match, then Maximum of Op1 & Op2
                    storage[i][j] = Math.max(storage[i][j - 1], storage[i - 1][j]);
                }
            }
        }
        return storage[m][n];
    }

    public static void main(String[] args) {
        String s = "adgei";
        String t = "abegi";
        System.out.println(lcsDP(s,t));
        System.out.println(lcsM(s,t));
        System.out.println(lcs(s,t));
    }
}
 ----------------------------------------------
         Output:
         3     // Quickly run
         3     // Quickly run
         3     // Take time in running
