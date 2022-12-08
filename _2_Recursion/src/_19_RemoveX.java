public class _19_RemoveX {
}
    Remove X
--------
        Given a string, compute recursively a new string where all 'x' chars have been removed.

        Input format :
        String S

        Output format :
        Modified String
        ---------------

        Create Project: Recursion

        Create Package: Default

        Create class:RemoveX
        -----------------------------------------
        import java.util.Scanner;

public class RemoveX {

    public static String removeX(String input) {

        if (input.length() == 0) {
            return input;
        }

        String ans = "";

        if (input.charAt(0) != 'x') {
            ans = ans + input.charAt(0);
        }
        String smallAns = removeX(input.substring(1));
        return ans + smallAns;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        System.out.println(removeX(input));
    }
}

----------------
        Input:
        aaaxxx
        Output:
        aaa