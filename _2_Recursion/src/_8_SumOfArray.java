public class _8_SumOfArray {
}

    Sum of Array
        -------------
        Given an array of length N, you need to find and return the sum of all elements of the array.
        Do this recursively.

        Input Format :
        Line 1 : An Integer N i.e. size of array
        Line 2 : N integers which are elements of the array, separated by spaces

        Output Format :
        Sum
        ---------------------------------------

        Create Project: Recursion

        Create Package: Default

        Create class: SumOfArray
        -----------------------------------------

        import java.util.Scanner;

public class SumOfArray {

    private static int sum(int input[], int startIndex) {
        if (startIndex == input.length) {
            return 0;
        }
        return input[startIndex] + sum(input, startIndex + 1);
    }
    public static int sum(int input[]) {
        return sum(input, 0);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int input[] = new int[n];
        for(int i = 0; i < n; i++) {
            input[i] = s.nextInt();
        }
        System.out.println(sum(input));
    }
}
--------------------
        Input:
        3
        4 5 2

        Output:
        11

        ****************************************************

        Create Project: Recursion

        Create Package: Default

        Create class: SumOfArray
        -----------------------------------------

        import java.util.*;
public class SumOfArray {

    public static int sum(int input[], int n) {
        if (n <= 0){
            return 0;
        }
        return sum(input, n - 1) + input[n - 1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        for(int i = 0; i < n; i++){
            a[i]=sc.nextInt();
        }
        System.out.println(sum(a, a.length));
    }
}
--------------------
        Input:
        3
        4 5 2

        Output:
        11

        ****************************************

        Create Project: WithoutRecursion

        Create Package: Default

        Create class: SumOfArray
        -----------------------------------------
        import java.util.Scanner;

public class SumOfArray{
    public static int sum(int input[]) {

        int sum = 0; // initialize sum
        int i;

        // Iterate through all elements and add them to sum
        for (i = 0; i < input.length; i++)
            sum +=  input[i];

        return sum;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int input[] = new int[n];
        for(int i = 0; i < n; i++) {
            input[i] = s.nextInt();
        }
        System.out.println(sum(input));
    }
}
Input:
        3
        4 5 2

        Output:
        11
