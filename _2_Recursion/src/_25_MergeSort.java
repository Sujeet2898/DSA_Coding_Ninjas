public class _25_MergeSort {
}
    Merge Sort Code
        ---------------
        Sort an array A using Merge Sort.
        Change in the input array itself. So no need to return or print anything.

        Input format :
        Line 1 : Integer n i.e. Array size
        Line 2 : Array elements (separated by space)

        Output format :
        Array elements in increasing order (separated by space)
        ------------------------------
        Time Complexity: O(nlogn)
        ------------------------------

        Create Project: Recursion

        Create Package: Default

        Create class: MergeSortCode
        -----------------------------------------
        Ascending Order
        -----------------------------------------
        import java.util.*;
public class MergeSortCode{

    public static void merge(int s1[], int s2[], int d[]){
        int i = 0;       // element in s1
        int j = 0;       // element in s2
        int k = 0;       // element in d

        // Copying elements of s1 and s2 into d by comparing
        while (i < s1.length && j < s2.length) {
            if (s1[i] <= s2[j]) {
                d[k] = s1[i];
                i++;
                k++;
            } else {
                d[k] = s2[j];
                k++;
                j++;
            }
        }

        // Copying remaining elements of s1 and s2 into d i.e original array (distinction)
        if (i < s1.length) {
            while (i < s1.length) {
                d[k] = s1[i];
                i++;
                k++;
            }
        }

        if (j < s2.length) {
            while (j < s2.length) {
                d[k] = s2[j];
                j++;
                k++;
            }
        }
    }

    public static void mergeSort(int[] input){
        if (input.length <= 1) {
            return;
        }

        // Splitting array into two parts
        int b[] = new int[input.length/2];
        int c[] = new int[input.length - b.length];

        // Coping half elements of input into b
        for (int i = 0; i < input.length/2; i++) {
            b[i] = input[i];
        }

        // Coping remaining elements of input into c
        for (int i = input.length/2; i < input.length; i++) {
            c[i - input.length/2] = input[i];
        }

        mergeSort(b);
        mergeSort(c);
        merge(b, c, input);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[]=new int[n];

        for(int i = 0; i < n; i++){
            a[i]=sc.nextInt();
        }
        mergeSort(a);
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
        import java.util.*;
public class MergeSortCode{

    public static void merge(int s1[], int s2[], int d[]){
        int i = 0;       // element in s1
        int j = 0;       // element in s2
        int k = 0;       // element in d

        // Copying elements of s1 and s2 into d by comparing
        while (i < s1.length && j < s2.length) {
            if (s1[i] >= s2[j]) {       // Only one change, other remain same
                d[k] = s1[i];
                i++;
                k++;
            } else {
                d[k] = s2[j];
                k++;
                j++;
            }
        }

        // Copying remaining elements of s1 and s2 into d i.e original array (distinction)
        if (i < s1.length) {
            while (i < s1.length) {
                d[k] = s1[i];
                i++;
                k++;
            }
        }

        if (j < s2.length) {
            while (j < s2.length) {
                d[k] = s2[j];
                j++;
                k++;
            }
        }
    }

    public static void mergeSort(int[] input){
        if (input.length <= 1) {
            return;
        }

        // Splitting array into two parts
        int b[] = new int[input.length/2];
        int c[] = new int[input.length - b.length];

        // Coping half elements of input into b
        for (int i = 0; i < input.length/2; i++) {
            b[i] = input[i];
        }

        // Coping remaining elements of input into c
        for (int i = input.length/2; i < input.length; i++) {
            c[i - input.length/2] = input[i];
        }

        mergeSort(b);
        mergeSort(c);
        merge(b, c, input);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[]=new int[n];

        for(int i = 0; i < n; i++){
            a[i]=sc.nextInt();
        }
        mergeSort(a);
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