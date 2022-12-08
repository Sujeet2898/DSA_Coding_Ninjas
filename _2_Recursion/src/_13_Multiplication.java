public class _13_Multiplication {
}

    Multiplication (Recursive)
--------------------------
        Given two integers M & N, calculate and return their multiplication using recursion. You can only use subtraction and addition for your calculation. No other operators are allowed.

        Input format :
        Line 1 : Integer M
        Line 2 : Integer N

        Output format :
        M x N
        -----------------------------

        Create Project: Recursion

        Create Package: Default

        Create class:  Multiplication
        -----------------------------------------
        import java.util.*;
public class Multiplication  {
    public static int multiplyTwoIntegers(int m, int n){

        if (n==0){
            return 0;
        }

        int smallAns = multiplyTwoIntegers(m,n-1);
        int ans = smallAns + m;

        return ans;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        System.out.println(multiplyTwoIntegers(m, n));
    }
}
--------------------
        Input:
        4
        5

        Output:
        20