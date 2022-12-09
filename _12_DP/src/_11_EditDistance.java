public class _11_EditDistance {
}
Q.  Code: Edit Distance
        ------------------------------------------------
        You are given two strings S and T of lengths M and N, respectively. Find the 'Edit Distance' between the strings.
        Edit Distance of two strings is the minimum number of steps required to make one string equal to the other. In order to do so, you can perform the following three operations:
        1. Delete a character
        2. Replace a character with another one
        3. Insert a character
        ------------------------------------------------
        Note :
        Strings don't contain spaces in between.
        ------------------------------------------------
        Input format :
        The first line of input contains the string S of length M.

        The second line of the input contains the String T of length N.
        Output format :
        Print the minimum 'Edit Distance' between the strings.
        ------------------------------------------------
        Create Project: Dynamic Programming

        Create Package: default

Create class: EditDistance
        -----------------------------------------------
public class EditDistance {

    /*   Time Complexity: Exponential i.e O(2^(m+n))    */

    public static int editDistance(String s, String t){

        // 2 BaseCase:

        // If first stringLength is 0, then no. of operations is equal to second stringLength
        if (s.length() == 0){
            return t.length();
        }
        // If second stringLength is 0, then no. of operations is equal to first stringLength
        if (t.length() == 0){
            return s.length();
        }

        // If stringLength is not 0

        // Comparing first character
        if (s.charAt(0) == t.charAt(0)){
            return editDistance(s.substring(1), t.substring(1));

        }else {

            //insert:  first complete string & second string whose first character is ignored
            int op1 = editDistance(s, t.substring(1));

            //delete:  first string whose first character is ignored & second complete string
            int op2 = editDistance(s.substring(1), t);

            //substitute:  first string whose first character is ignored & second string whose first character is ignored
            int op3 = editDistance(s.substring(1), t.substring(1));

            return 1 + Math.min(op1, Math.min(op2, op3));
        }
    }

    /*   Time Complexity: O(m+n) by using Memoization Technique    */

    public static int editDistanceM(String s, String t){
        int m = s.length();
        int n = t.length();

        // Making storageArray of m+1, n+1 size
        int storage[][] = new int[m + 1][n + 1];

        // Initially storageArray is empty
        for (int i = 0; i <= m; i++){
            for (int j = 0; j <= n; j++){
                storage[i][j] = -1;
            }
        }

        // recursive call
        return editDistanceM(s, t, storage);
    }

    // Private function for storing result (only unique result to avoid redundancy)
    private static int editDistanceM(String s, String t, int[][] storage){
        int m = s.length();
        int n = t.length();

        // Checking already calculated value
        if (storage[m][n] != -1){
            return storage[m][n];
        }

        // 2 BaseCase:

        // If first stringLength is 0, then no. of operations is equal to second stringLength
        if(m == 0){
            storage[m][n] = n;
            return storage[m][n];
        }
        // If second stringLength is 0, then no. of operations is equal to first stringLength
        if(n == 0){
            storage[m][n] = m;
            return storage[m][n];
        }

        // If stringLength is not 0

        // Comparing first character
        if (s.charAt(0) == t.charAt(0)){
            storage[m][n] = editDistanceM(s.substring(1),t.substring(1), storage);
        }else {
            //insert:  first complete string & second string whose first character is ignored
            int op1 = editDistanceM(s, t.substring(1), storage);

            //delete:  first string whose first character is ignored & second complete string
            int op2 = editDistanceM(s.substring(1), t, storage);

            //substitute:  first string whose first character is ignored & second string whose first character is ignored
            int op3 = editDistanceM(s.substring(1), t.substring(1), storage);

            // Storing the newly calculated value in the array to avoid repetition
            storage[m][n] = 1 + Math.min(op1, Math.min(op2, op3));
        }
        return storage[m][n];
    }

    /*   Time Complexity: O(n) by using Dynamic Programming  */

    public static int editDistanceDP(String s, String t){
        int m = s.length();
        int n = t.length();

        // Our target is to store result in a storageArray
        int storage[][] = new int[m + 1][n + 1];

        // 2 BaseCase:

        // Entry corresponding to first row
        for (int j = 0; j <= n; j++){
            storage[0][j] = j;
        }
        // Entry corresponding to first column
        for (int i = 0; i <= m; i++){
            storage[i][0] = i;
        }

        // "double for" loop for next entries of remaining cells
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){

                // Comparing ith character from last of 1st String & jth character from last of 2nd String because characters are removed from starting
                if (s.charAt(m - i) == t.charAt(n - j)){
                    storage[i][j] = storage[i - 1][j - 1];

                }else{

                    // If the last character doesn't match, then Maximum of Op1, Op2 & Op3
                    storage[i][j] = 1 + Math.min(storage[i][j - 1], Math.min(storage[i - 1][j], storage[i - 1][j - 1]));
                }
            }
        }
        return storage[m][n];
    }

    public static void main(String[] args) {
        String s = "adef";
        String t = "gbde";
        System.out.println(editDistanceDP(s,t));
        System.out.println(editDistanceM(s,t));
        System.out.println(editDistance(s,t));
    }
}
 ----------------------------------------------
         Output:
         3     // Quickly run
         3     // Quickly run
         3     // Take time in running