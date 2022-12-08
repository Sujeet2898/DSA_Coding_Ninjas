public class _23_ReplaceCharacter {
}

    Replace Character Recursively
        ------------------------------
        Given an input string S and two characters c1 and c2, you need to replace every occurrence of character c1 with character c2 in the given string.
        Do this recursively.

        Input Format :
        Line 1 : Input String S
        Line 2 : Character c1 and c2 (separated by space)

        Output Format :
        Updated string
        ------------------

        Create Project: Recursion

        Create Package: Default

        Create class: ReplaceCharacter
        -----------------------------------------
        import java.util.*;
public class ReplaceCharacter{

    public static String replaceCharacter(String input, char c1, char c2) {
        if (input.length() == 0) {
            return input;
        }

        String smallOutput = replaceCharacter(input.substring(1), c1, c2);
        if (input.charAt(0) == c1) {
            return c2 + smallOutput;
        } else {
            return input.charAt(0) + smallOutput;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String input = scn.nextLine();
        char c1 = scn.next().charAt(0);
        char c2 = scn.next().charAt(0);
        System.out.println(replaceCharacter(input, c1, c2));
    }
}
----------------
        Input:
        vyyv
        y
        v
        Output:
        vvvv
        ----------
        Input:
        nn
        n
        u
        Output:
        uu