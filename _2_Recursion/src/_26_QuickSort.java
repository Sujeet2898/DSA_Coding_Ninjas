public class _26_QuickSort {
}
    Quick Sort Code
        ---------------
        Sort an array A using Quick Sort.
        Change in the input array itself. So no need to return or print anything.

        Input format :
        Line 1 : Integer n i.e. Array size
        Line 2 : Array elements (separated by space)

        Output format :
        Array elements in increasing order (separated by space)
        -----------------------------------------------------------
        Time Complexity: O(nlogn)
        -----------------------------------------------------------

        Create Project: Recursion

        Create Package: Default

        Create class: QuickSortCode
        -----------------------------------------
        Ascending Order
        -----------------------------------------
        import java.util.*;
public class QuickSortCode{

    public static int partition(int a[], int si, int ei) {
        int pivotElement = a[si];
        int smallerNumCount = 0;
        for (int i = si + 1; i <= ei; i++) {
            if (a[i] < pivotElement) {
                smallerNumCount++;
            }
        }
        int temp = a[si + smallerNumCount];
        a[si + smallerNumCount] = pivotElement;
        a[si] = temp;

        // Take i = si & j = ei to avoid runtimeError (ArrayIndexOutOfBoundsException)
        int i = si;
        int j = ei;
        while (i < j) {
            if (a[i] < pivotElement) {
                i++;
            } else if (a[j] >= pivotElement) {
                j--;
            } else {
                temp = a[i];      // If both above condition is incorrect
                a[i] = a[j];      // So, we swap both wrong elements left and right of pivotElement
                a[j] = temp;
                i++;
                j--;
            }
        }
        return si + smallerNumCount;    // return pivotIndex
    }

    private static void quickSort(int a[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int pivotIndex = partition(a, si, ei);
        quickSort(a, si, pivotIndex - 1);
        quickSort(a, pivotIndex + 1, ei);
    }

    public static void quickSort(int[] input) {
        quickSort(input, 0, input.length - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[]=new int[n];

        for(int i = 0; i < n; i++){
            a[i]=sc.nextInt();
        }
        quickSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
-------------------
        Input:
        5
        7 8 4 9 1
        Output:
        1 4 7 8 9
        ----
        ***********************************

        Decending Order
        -----------------------------------------
        Only three changes, other remain same
        -----------------------------------------
        import java.util.*;
public class Solution{

    public static int partition(int a[], int si, int ei) {
        int pivotElement = a[si];
        int smallerNumCount = 0;
        for (int i = si + 1; i <= ei; i++) {
            if (a[i] > pivotElement) {      // 1st change
                smallerNumCount++;
            }
        }
        int temp = a[si + smallerNumCount];
        a[si + smallerNumCount] = pivotElement;
        a[si] = temp;

        int i =si;
        int j = ei;
        while (i < j) {
            if (a[i] > pivotElement) {     // 2nd change
                i++;
            } else if (a[j] <= pivotElement) {   // 3rd change
                j--;
            } else {
                temp = a[i];      // If both above condition is incorrect
                a[i] = a[j];      // So, we swap both wrong elements left and right of pivotElement
                a[j] = temp;
                i++;
                j--;
            }
        }
        return si + smallerNumCount;    // return pivotIndex
    }

    private static void quickSort(int a[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int pivotIndex = partition(a, si, ei);
        quickSort(a, si, pivotIndex - 1);
        quickSort(a, pivotIndex + 1, ei);
    }

    public static void quickSort(int[] input) {
        quickSort(input, 0, input.length - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[]=new int[n];

        for(int i = 0; i < n; i++){
            a[i]=sc.nextInt();
        }
        quickSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
-------------------
        Input:
        5
        7 8 4 9 1
        Output:
        9 8 7 4 1
        ----