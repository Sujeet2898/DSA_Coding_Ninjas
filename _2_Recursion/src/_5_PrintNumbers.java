public class _5_PrintNumbers {
}

    Given is the code to print numbers from 1 to n in increasing order recursively. But it contains few bugs that you need to rectify such that all the test cases pass.

        Input Format :
        Integer n

        Output Format :
        Numbers from 1 to n (separated by space)
        ---------------------------------------------------------

        import java.util.*;
public class Solution {

    public static void print(int n){
        if (n == 0) {
            return;
        }

        print(n - 1);
        System.out.print(n + " ");
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        print(n);
    }
}
--------------------------------------
        Input:
        15
        Output:
        1 2 3 4 5 6 7 8 9 10 11 12 13 14 15