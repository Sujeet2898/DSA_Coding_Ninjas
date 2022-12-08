public class _27_ReturnSubsequences {
}

    Create Project: Recursion

        Create Package: Default

        Create class: ReturnSubsequences
        -----------------------------------------
        import java.util.*;
public class ReturnSubsequences{

    public static String[] findSubsequences(String str){

        if (str.length() == 0){
            String ans[] = {""};
            return ans;
        }

        String smallAns[] = findSubsequences(str.substring(1));
        String ans[] = new String[2 * smallAns.length];

        for (int i = 0; i < smallAns.length; i++){
            ans[i] = smallAns[i];
        }

        for (int i = 0; i < smallAns.length; i++){
            ans[i + smallAns.length] = str.charAt(0) + smallAns[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String ans[] = findSubsequences(str);

        for(int i = 0; i < ans.length; i++){
            System.out.println(ans[i]);
        }
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