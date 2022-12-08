public class _10_FirstIndexOfNumber {
}

    First Index of Number
----------------------
        Given an array of length N and an integer x, you need to find and return the first index of integer x present in the array. Return -1 if it is not present in the array.
        First index means, the index of first occurrence of x in the input array.
        Do this recursively. Indexing in the array starts from 0.

        Input Format :
        Line 1 : An Integer N i.e. size of array
        Line 2 : N integers which are elements of the array, separated by spaces
        Line 3 : Integer x

        Output Format :
        first index or -1
        ---------------------

        Create Project: Recursion

        Create Package: Default

        Create class:  FirstIndexOfNumber
        -----------------------------------------

        import java.util.Scanner;

public class FirstIndexOfNumber {

    private static int indexBtao(int input[], int x, int startIndex){

        if (startIndex==input.length-1){
            return -1;
        }

        if (input[startIndex] == x){
            return startIndex;
        }

        return indexBtao(input, x, startIndex+1);

    }

    public static int firstIndex(int input[], int x) {
        return indexBtao(input,x,0);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int input[] = new int[n];
        for(int i = 0; i < n; i++) {
            input[i] = s.nextInt();
        }
        int x = s.nextInt();
        System.out.println(firstIndex(input, x));
    }
}
--------------------
        Input:
        4
        4 5 2 5
        5

        Output:
        1