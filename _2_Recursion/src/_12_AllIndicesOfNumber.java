public class _12_AllIndicesOfNumber {
}

    All Indices of Number
----------------------
        Given an array of length N and an integer x, you need to find all the indexes where x is present in the input array. Save all the indexes in an array (in increasing order).
        Do this recursively. Indexing in the array starts from 0.

        Input Format :
        Line 1 : An Integer N i.e. size of array
        Line 2 : N integers which are elements of the array, separated by spaces
        Line 3 : Integer x

        Output Format :
        indexes where x is present in the array (separated by space)
        ------------------------------------------------------------

        Create Project: Recursion

        Create Package: Default

        Create class: AllIndicesOfNumber
        -----------------------------------------

        import java.util.*;
public class AllIndicesOfNumber {

    public static int[] allIndexBtao(int input[], int x, int startIndex){

        //if startIndex reaches the end return empty array.
        if(startIndex == input.length){
            int[] output = new int[0];
            return output;
        }

        //recursion

        int[] smallOutput = allIndexBtao(input,x, startIndex+1);

        //if the number is found at startIndex

        if (input[startIndex] == x){

            int[] output = new int[smallOutput.length +1];
            //return startIndex;


            //shift elements to accommodate the starting index
            output[0] = startIndex;

            for(int i = 0; i<smallOutput.length; i++){
                output[i+1] = smallOutput[i];
            }
            return output;

        }else{
            return smallOutput;
        }

    }

    public static int[] allIndexes(int input[], int x) {

        return allIndexBtao(input,x,0);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int input[] = new int[n];

        for(int i = 0; i < n; i++){
            input[i]=sc.nextInt();
        }
        int x = sc.nextInt();

        int output[] = allIndexes(input, x);

        for(int i = 0; i < output.length; i++) {
            System.out.print(output[i] + " ");
        }
    }
}
---------------------------
        Input:
        7
        4 5 4 6 4 8 4
        4

        Output:
        0 2 4 6


