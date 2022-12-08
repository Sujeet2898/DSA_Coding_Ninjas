public class _21_PairStar {
}

    Pair Star
-----------
        Given a string S, compute recursively a new string where identical chars that are adjacent in the original string are separated from each other by a "*".

        Input format :
        String S

        Output format :
        Modified string
        ------------------

        Create Project: Recursion

        Create Package: Default

        Create class: PairStar
        -----------------------------------------

        import java.util.Scanner;
public class PairStar {

    // Return the updated string
    public static String addStars(String s) {

        if (s.length()<=1){
            return s;
        }

        String out = addStars(s.substring(1));

        if (s.charAt(0)==s.charAt(1)){
            out = s.charAt(0) + "*" + s.charAt(1) + out.substring(1);
        }else{
            out = s.charAt(0) + out;
        }
        return out;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        System.out.println(addStars(input));
    }
}

--------------------------------------
        Input:
        hello
        Output:
        hel*lo