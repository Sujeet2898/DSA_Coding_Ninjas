public class _14_CountZeros {
}

    Count Zeros
------------
        Given an integer N, count and return the number of zeros that are present in the given integer using recursion.

        Input Format :
        Integer N

        Output Format :
        Number of zeros in N
        -----------------------------

        Create Project: Recursion

        Create Package: Default

        Create class:  CountZeros
        -----------------------------------------
        import java.util.*;
public class CountZeros {

    public static int countZerosRec(int input){

        if (input < 10){
            if (input == 0){
                return 1;
            } else {
                return 0;
            }
        }

        if (input % 10 == 0){
            return countZerosRec(input / 10) + 1;
        } else {
            return countZerosRec(input / 10);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(countZerosRec(n));
    }
}
--------------------
        Input:
        100

        Output:
        2
        ----------------
        Input:
        10

        Output:
        1
        ---------------
        Input:
        0

        Output:
        1