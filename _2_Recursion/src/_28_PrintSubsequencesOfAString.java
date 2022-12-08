public class _28_PrintSubsequencesOfAString {
}
    Create Project: Recursion

        Create Package: Default

        Create class: PrintSubsequences
        -----------------------------------------
        import java.util.*;
public class PrintSubsequences{

    public static void printSubsequences(String input, String outputSoFar){

        if (input.length() == 0){
            System.out.println(outputSoFar);
            return;
        }

        // We choose not to include the first character
        printSubsequences(input.substring(1), outputSoFar);

        // We choose to include the first character
        printSubsequences(input.substring(1), outputSoFar + input.charAt(0));
    }

    public static void printSubsequences(String input){
        printSubsequences(input, "");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        printSubsequences(input);
    }
}
----------------
        Input:
        xyz

        Output:
        // first one is empty string
        z      // this is second
        y      // and so on....
        yz
        x
        xz
        xy
        xyz
        --------------