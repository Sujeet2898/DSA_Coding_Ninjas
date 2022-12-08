public class _4_CalculatePower {
}

    Write a program to find x to the power n (i.e. x^n). Take x and n from the user. You need to return the answer.
        --------------------------------------------------

        import java.util.*;
public class Solution {

    public static int power(int x, int n) {

        if (n == 0) {
            return 1;
        }

        int smallOutput = power(x, n-1);
        int output = x * power(x, n-1);
        return output;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        System.out.println(power(x, n));
    }
}
-------------------------------
        Input:
        0 1
        Output:
        0

        Input:
        4 0
        Output:
        1

        Input:
        0 0
        Output:
        1
