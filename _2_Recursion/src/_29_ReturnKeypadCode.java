public class _29_ReturnKeypadCode {
}
    Return Keypad Code
        -------------------
        Given an integer n, using phone keypad find out all the possible strings that can be made using digits of input n.
        Return empty string for numbers 0 and 1.

        Note : 1. The order of strings are not important.
        2. Input and output has already been managed for you. You just have to populate the output array and return the count of elements populated in the output array.

        Input Format :
        Integer n

        Output Format :
        All possible strings in different lines
        ----------------------------------------


        Create Project: Recursion

        Create Package: Default

        Create class: ReturnKeypadCode
        -----------------------------------------
        import java.util.*;
public class ReturnKeypadCode{

    public static char[] numberOptions(int n){
        switch (n){
            case 2:
                char options2[] = {'a', 'b', 'c'};
                return options2;
            case 3:
                char options3[] = {'d', 'e', 'f'};
                return options3;
            case 4:
                char options4[] = {'g', 'h', 'i'};
                return options4;
            case 5:
                char options5[] = {'j', 'k', 'l'};
                return options5;
            case 6:
                char options6[] = {'m', 'n', 'o'};
                return options6;
            case 7:
                char options7[] = {'p', 'q', 'r', 's'};
                return options7;
            case 8:
                char options8[] = {'t', 'u', 'v'};
                return options8;
            case 9:
                char options9[] = {'w', 'x', 'y', 'z'};
                return options9;
            default:
                char options[] = {'\0'};
                return options;
        }
    }

    public static String[] returnKeypad(int n){
        if (n == 0){                 // base case
            String ans[] = {""};
            return ans;
        }
        int lastDigit = n % 10;
        int smallerNumber = n / 10;
        String smallAns[] = returnKeypad(smallerNumber);
        char options[] = numberOptions(lastDigit);
        String ans[] = new String[smallAns.length * options.length];

        int k = 0;  // For inserting value at index of ans[] array
        for (int i = 0; i < smallAns.length; i++){
            for (int j = 0; j < options.length; j++){
                ans[k] = smallAns[i] + options[j];
                k++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String ans[] = returnKeypad(n);
        for (int i = 0; i < ans.length; i++){
            System.out.println(ans[i]);
        }
    }
}
----------------
        Input:
        23
        Output:
        ad
        bd
        cd
        ae
        be
        ce
        af
        bf
        cf
        --------------
        Input:
        8
        Output:
        t
        u
        v
        --------------
        Input:
        354
        Output:
        djg
        ejg
        fjg
        dkg
        ekg
        fkg
        dlg
        elg
        flg
        djh
        ejh
        fjh
        dkh
        ekh
        fkh
        dlh
        elh
        flh
        dji
        eji
        fji
        dki
        eki
        fki
        dli
        eli
        fli