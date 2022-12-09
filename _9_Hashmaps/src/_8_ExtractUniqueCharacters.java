public class _8_ExtractUniqueCharacters {
}
    Q.  Extract Unique characters
        --------------------------------------------------
        Given a string S, you need to remove all the duplicates. That means, the output string should contain each character only once. The respective order of characters should remain same, as in the input string.
        ---------------------------------------------------
        Create Project: Maps

        Create Package: Default

        Create class: ExtractUniqueCharacters
        ----------------------------------------------------
        import java.util.HashMap;

public class ExtractUniqueCharacters {

    public static String uniqueChar(String str){
        String x="";
        HashMap<Character, Boolean> map = new HashMap<>();

        // Iterate in String
        for(int i=0;i<str.length();i++) {

            // if map doesn't contain single unique character
            if (!map.containsKey(str.charAt(i))) {

                // means map contain duplicates
                map.put(str.charAt(i), true);

                // add this integer into String x
                x += str.charAt(i);
            }
        }
        return x;
    }

    public static void main(String[] args) {
        String str = "codingninjas";
        System.out.println(uniqueChar(str));
    }
}
----------------------
        output:
        codingjas
