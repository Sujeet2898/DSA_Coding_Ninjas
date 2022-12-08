public class _6_NumberOfDigits {
}

    Number of Digits
        ----------------
        Given the code to find out and return the number of digits present in a number recursively. But it contains few bugs, that you need to rectify such that all the test cases should pass.

        Input Format :
        Integer n

        Output Format :
        Count of digits
        ---------------

        import java.util.*;
public class Solution
{
    public static int count(int n) {
        if (n == 0) {
            return 0;
        }

        int smallOutput = count(n/10);
        int output = smallOutput + 1;
        return output;

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(count(n));
    }
}
-------------------
        Input:
        156
        Output:
        3

        Input:
        600
        Output:
        3

        Input:
        656
        Output:
        3