public class _9_CheckNumberInArray {
}

    Check Number in Array
---------------------
        Given an array of length N and an integer x, you need to find if x is present in the array or not. Return true or false.
        Do this recursively.

        Input Format :
        Line 1 : An Integer N i.e. size of array
        Line 2 : N integers which are elements of the array, separated by spaces
        Line 3 : Integer x

        Output Format :
        'true' or 'false'
        -------------------------------

        Create Project: Recursion

        Create Package: Default

        Create class: CheckNumberInArray
        -----------------------------------------

        import java.util.Scanner;

public class CheckNumberInArray {

    private static boolean checkNumber(int input[], int x, int startIndex){
        if (startIndex == input.length){
            return false;
        }
        if (input[startIndex] == x){
            return true;
        }
        return checkNumber(input, x, startIndex + 1);
    }

    public static boolean checkNumber(int input[], int x){
        return checkNumber(input, x, 0);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int input[] = new int[n];
        for(int i = 0; i < n; i++) {
            input[i] = s.nextInt();
        }
        int x = s.nextInt();
        System.out.println(checkNumber(input, x));
    }
}

--------------------
        Input:
        3
        4 5 2
        4

        Output:
        true
        ---------
        Input:
        3
        4 5 2
        1

        Output:
        false