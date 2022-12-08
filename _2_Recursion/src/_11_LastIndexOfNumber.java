public class _11_LastIndexOfNumber {
}

    Last Index of Number
--------------------
        Given an array of length N and an integer x, you need to find and return the last index of integer x present in the array. Return -1 if it is not present in the array.
        Last index means - if x is present multiple times in the array, return the index at which x comes last in the array.
        You should start traversing your array from 0, not from (N - 1).
        Do this recursively. Indexing in the array starts from 0.

        Input Format :
        Line 1 : An Integer N i.e. size of array
        Line 2 : N integers which are elements of the array, separated by spaces
        Line 3 : Integer x

        Output Format :
        last index or -1
        ---------------------------------

        Create Project: Recursion

        Create Package: Default

        Create class:  LastIndexOfNumber
        -----------------------------------------
        import java.util.Scanner;

public class LastIndexOfNumber {

    private static int indexBtao(int input[], int x, int startIndex){

        if (startIndex==0){
            return -1;
        }

        if (input[startIndex] == x){
            return startIndex;
        }

        return indexBtao(input, x, startIndex-1);

    }

    public static int lastIndex(int input[], int x) {
        return indexBtao(input,x,input.length-1);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int input[] = new int[n];
        for(int i = 0; i < n; i++) {
            input[i] = s.nextInt();
        }
        int x = s.nextInt();
        System.out.println(lastIndex(input, x));
    }
}
--------------------
        Input:
        4
        4 5 2 5
        5

        Output:
        3