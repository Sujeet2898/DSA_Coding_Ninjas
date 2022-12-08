public class _33_BinarySearch {
}
    Binary Search (Recursive)
-------------------------
        Given an integer sorted array (sorted in increasing order) and an element x, find the x in given array using binary search. Return the index of x.
        Return -1 if x is not present in the given array.

        Note : If given array size is even, take first mid.

        Input format :
        Line 1 : Array size
        Line 2 : Array elements (separated by space)
        Line 3 : x (element to be searched)
        ------------------------------------

        Create Project: Recursion

        Create Package: Default

        Create class: BinarySearch
        -----------------------------------------
        import java.util.*;
public class solution{

    public static int binarySearch(int a[], int si, int ei, int x){
        if (si > ei) {
            return -1;
        }
        int midIndex = (si + ei)/2;
        if (a[midIndex] == x) {
            return midIndex;
        } else if (a[midIndex] < x) {   // x is present right side
            return binarySearch(a, midIndex + 1, ei, x);
        } else {     // x is present left side
            return binarySearch(a, si, midIndex - 1, x);
        }
    }

    public static int binarySearch(int input[], int element) {
        return binarySearch(input, 0, input.length - 1, element);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int input[]=new int[n];

        for(int i = 0; i < n; i++){
            input[i]=sc.nextInt();
        }
        int element = sc.nextInt();
        System.out.println(binarySearch(input, element));
    }
}
--------------------------
        Input:
        6
        2 3 4 5 6 8
        5

        Output:
        3
