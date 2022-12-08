public class _16_CheckPalindrome {
}

    Check Palindrome (recursive)
----------------------------
        Check whether a given String S is a palindrome using recursion. Return true or false.

        Input Format :
        String S

        Output Format :
        'true' or 'false'
        ---------------------

        Create Project: Recursion

        Create Package: Default

        Create class:  CheckPalindrome
        -----------------------------------------
        import java.util.*;
public class CheckPalindrome {

    public static boolean indexBtao(String input, int startIndex, int endIndex){

        if(startIndex == endIndex){
            return true;
        }

        if (input.charAt(startIndex)!=input.charAt(endIndex)){
            return false;
        }

        if (startIndex<endIndex+1){
            return indexBtao(input,startIndex+1,endIndex-1);
        }

        return true;
    }

    public static boolean isStringPalindrome(String input) {

        if(input.length()==0){
            return true;
        }

        boolean ans = indexBtao(input,0, input.length()-1);
        return ans;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        System.out.println(isStringPalindrome(input));
    }
}
--------------------
        Input:
        racecar

        Output:
        true
        -------
        Input:
        naman

        Output:
        true
