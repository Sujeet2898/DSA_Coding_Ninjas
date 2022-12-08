public class _18_ReplacePi {
}

    Replace pi (recursive)
----------------------
        Given a string, compute recursively a new string where all appearances of "pi" have been replaced by "3.14".
        ---------------------------


        Create Project: Recursion

        Create Package: Default

        Create class: ReplacePi
        -----------------------------------------

        import java.util.*;
public class ReplacePi{

    public static String replace(String input){
        if (input.length() <= 1) {
            return input;
        }

        if (input.charAt(0) == 'p' && input.charAt(1) == 'i') {
            // call recursion on string of length n - 2
            String smallOutput = replace(input.substring(2));
            return "3.14" + smallOutput;
        } else {
            // call recursion on string of length n -1
            String smallOutput = replace(input.substring(1));
            return input.charAt(0) + smallOutput;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        System.out.println(replace(s));
    }
}
----------------
        Input:
        pippiippip
        Output:
        3.14p3.14ip3.14p
