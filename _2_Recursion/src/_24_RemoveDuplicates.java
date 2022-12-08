public class _24_RemoveDuplicates {
}

    Remove Duplicates Recursively
        -------------------------------
        Given a string S, remove consecutive duplicates from it recursively.

        Input Format :
        String S

        Output Format :
        Output string
        ---------------

        Create Project: Recursion

        Create Package: Default

        Create class: RemoveDuplicates
        -----------------------------------------
        import java.util.*;
public class RemoveDuplicates{

    public static String removeConsecutiveDuplicates(String s) {

        String ans = "";

        if(s.length()==1){
            return s;
        }

        if(s.charAt(0)!=s.charAt(1)){
            ans = ans + s.charAt(0);
        }

        String Smallans = removeConsecutiveDuplicates(s.substring(1));
        return ans + Smallans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        System.out.println(removeConsecutiveDuplicates(s));
    }
}
----------------
        Input:
        CCooddiinnggNNiinnnnjjjjaaaassss
        Output:
        CodingNinjas
