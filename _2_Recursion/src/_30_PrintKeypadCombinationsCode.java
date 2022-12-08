public class _30_PrintKeypadCombinationsCode {
}
    Print Keypad Combinations Code
----------------------------------
        Given an integer n, using phone keypad find out and print all the possible strings that can be made using digits of input n.

        Note : The order of strings are not important. Just print different strings in new lines.

        Input Format :
        Integer n

        Output Format :
        All possible strings in different lines
        ------------------------------------------

        Create Project: Recursion

        Create Package: Default

        Create class: PrintKeypadCode
        -----------------------------------------
        import java.util.*;
public class PrintKeypadCode{

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

    public static void printKeypad(int n){
        printKeypad(n, "");
    }

    private static void printKeypad(int n, String outputSoFar){
        if (n == 0){
            System.out.println(outputSoFar);
            return;
        }
        int lastDigit = n % 10;
        char options[] = numberOptions(lastDigit);
        for (int i = 0; i < options.length; i++){
            printKeypad(n / 10, options[i] + outputSoFar);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printKeypad(n);
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