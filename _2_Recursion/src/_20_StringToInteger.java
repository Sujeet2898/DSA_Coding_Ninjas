public class _20_StringToInteger {
}

    String to Integer
        -----------------
        Write a recursive function to convert a given string into the number it represents. That is input will be a numeric string that contains only numbers, you need to convert the string into corresponding integer and return the answer.

        Input format :
        Numeric string S (string, Eg. "1234")

        Output format :
        Corresponding integer N (int, Eg. 1234)
        ----------------------------------------


        Create Project: Recursion

        Create Package: Default

        Create class: StringToInteger
        -----------------------------------------

        import java.util.Scanner;

public class StringToInteger {

    public static int convertStringToInt(String input) {
        if (input.length() == 1){
            return input.charAt(0) - '0';
        }
        int smallOutput = convertStringToInt(input.substring(0, input.length() - 1));
        int lastDigit = input.charAt(input.length() - 1) - '0';
        return smallOutput * 10 + lastDigit;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        System.out.println(convertStringToInt(input));
    }
}
--------------------------------------
        Input:
        1231
        Output:
        1231
        -----------------
        Input:
        1099
        Output:
        1099
        -------------
        Input:
        15667
        Output:
        15667