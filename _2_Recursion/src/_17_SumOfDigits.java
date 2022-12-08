public class _17_SumOfDigits {
}

    Sum of digits (recursive)
-------------------------
        Write a recursive function that returns the sum of the digits of a given integer.

        Input format :
        Integer N

        Output format :
        Sum of digits of N
        --------------------

        Create Project: Recursion

        Create Package: Default

        Create class: SumOfDigits
        -----------------------------------------
        import java.util.*;
public class SumOfDigits {

    public static int sumOfDigits(int input){
        if(input==0){
            return 0;
        }

        int smallAns = sumOfDigits(input/10);
        int ans = smallAns + (input%10);

        return ans;

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int input = s.nextInt();
        System.out.println(sumOfDigits(input));
    }
}
--------------------
        Input:
        1231

        Output:
        7
        -------
        Input:
        15667

        Output:
        25