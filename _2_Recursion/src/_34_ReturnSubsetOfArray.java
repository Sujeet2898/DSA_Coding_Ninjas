public class _34_ReturnSubsetOfArray {
}
    Return subset of an array
        ---------------------------
        Given an integer array (of length n), find and return all the subsets of input array.
        Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.

        Note : The order of subsets are not important.

        Input format :
        Line 1 : Size of array
        Line 2 : Array elements (separated by space)
        ----------------------------------------------


        Create Project: Recursion

        Create Package: Default

        Create class: ReturnSubsetOfArray
        -----------------------------------------
        import java.util.*;
public class ReturnSubsetOfArray{

    public static int[][] findsubsets(int arr[], int start){

        //base case
        //if start pointer reaches the end of array, return empty array


        if (start>arr.length-1){
            int output[][] = new int[1][0];
            //output[0][0] = arr[start];
            return output;
        }

        //recursion call

        //make smallAns array
        int[][] smallAns = findsubsets(arr, start+1);

        //make ans array
        int ans[][] = new int [2*smallAns.length][];

        //copy elements as it is into the jagged array
        for(int i = 0; i<smallAns.length; i++){
            ans[i] = new int[smallAns[i].length];
            for(int j = 0; j<smallAns[i].length; j++){
                ans[i][j] = smallAns[i][j];
            }
        }

        //copy elements after adding the first element
        for(int i = smallAns.length; i<ans.length; i++){
            ans[i] = new int[smallAns[i-smallAns.length].length+1];
            ans[i][0] = arr[start];
            for(int j = 1; j<ans[i].length; j++){
                ans[i][j] = smallAns[i-smallAns.length][j-1];
            }
        }

        return ans;

    }

    // Return a 2D array that contains all the subsets
    public static int[][] subsets(int input[]) {
        // Write your code here

        int start = 0;
        int[][] jawaab = findsubsets(input,start);
        return jawaab;

    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = s.nextInt();
        }
        int output[][] = subsets(arr);
        for(int i = 0; i < output.length; i++) {
            for(int j = 0; j < output[i].length; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }
    }
}
----------------
        Input:
        3
        19 3 9

        Output:
        9
        3
        3 9
        19
        19 9
        19 3
        19 3 9