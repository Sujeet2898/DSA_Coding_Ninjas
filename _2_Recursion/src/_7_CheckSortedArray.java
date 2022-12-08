public class _7_CheckSortedArray {
}

    Create Project: Recursion

        Create Package: Default

        Create class: CheckSorted
        -----------------------------------------

public class CheckSorted {

    public static boolean checkSorted(int input[])	{
        if(input.length <= 1)	{ //Base	Case
            return true;
        }
        if (input[0] > input[1]){
            return false;
        }

        int smallInput[] = new int[input.length - 1];
        for (int i = 1; i < input.length; i++) {
            smallInput[i - 1] = input[i];        // copying n - 1 part except first part of n
        }

        boolean smallAns = checkSorted(smallInput);   //Small Calculation and return statement
        return smallAns;
    }

    public static void main(String[] args) {
        int input[] = {2,3,3,6,9};
        System.out.println(checkSorted(input));
    }
}
--------------------
        Output:
        true

        *******************************************************

        Better approach then first one Without creating Copying of array each time, By simply creating startIndex.
        ----------------------------------------------------------------------------------------------------------

        Create Project: Recursion

        Create Package: Default

        Create class: CheckSortedBetter
        -----------------------------------------

        import java.util.Scanner;
public class CheckSortedBetter {
    public static boolean checkSortedBetter(int input[], int startIndex){
        if(startIndex >= input.length - 1)	{
            return true;
        }
        if (input[startIndex] > input[startIndex + 1]){
            return false;
        }
        boolean smallAns = checkSortedBetter(input, startIndex + 1);
        return smallAns;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int input[] = new int[n];
        for(int i = 0; i < n; i++) {
            input[i] = s.nextInt();
        }
        System.out.println(checkSortedBetter(input, 0));
    }
}
--------------------
        Input:
        4
        7 8 9 12

        Output:
        true
        ---------------
        Input:
        4
        7 6 9 12

        Output:
        false

        **********************************************

        Hiding the logic of startIndex from the third Person
        ----------------------------------------------------

        Create Project: Recursion

        Create Package: Default

        Create class: CheckSortedBetter
        -----------------------------------------

        import java.util.Scanner;
public class CheckSortedBetter {
    private static boolean checkSortedBetter(int input[], int startIndex){      // making private
        if(startIndex >= input.length - 1)	{
            return true;
        }
        if (input[startIndex] > input[startIndex + 1]){
            return false;
        }
        boolean smallAns = checkSortedBetter(input, startIndex + 1);
        return smallAns;
    }

    public static boolean checkSortedBetter(int input[]){
        return checkSortedBetter(input, 0);
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int input[] = new int[n];
        for(int i = 0; i < n; i++) {
            input[i] = s.nextInt();
        }
        System.out.println(checkSortedBetter(input, 0));
    }
}
--------------------
        Input:
        4
        7 8 9 12

        Output:
        true
        ---------------
        Input:
        4
        7 6 9 12

        Output:
        false
