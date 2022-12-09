public class _8_MinimumBracketReversal {
}
    Q.  Minimum bracket Reversal
        -----------------------------
        For a given expression in the form of a string, find the minimum number of brackets that can be reversed in order to make the expression balanced. The expression will only contain curly brackets.

        If the expression can't be balanced, return -1.

        Example:
        --------
        Expression: {{{{
        If we reverse the second and the fourth opening brackets, the whole expression will get balanced. Since we have to reverse two brackets to make the expression balanced, the expected output will be 2.

        Expression: {{{
        In this example, even if we reverse the last opening bracket, we would be left with the first opening bracket and hence will not be able to make the expression balanced and the output will be -1.
        ------------------------------

        Create Project: Stack

        Create Package: default

Create class: StackCollections
        -------------------------------
        import java.util.Stack;
        import java.util.*;

public class StackCollections {

    public static int countBracketReversals(String str) {

        // Odd no. of brackets
        if (str.length() % 2 != 0){
            return -1;
        }

        // Creating Stack of Character type
        Stack<Character> stack = new Stack<>();

        int count = 0;

        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            // Opening bracket
            if (ch == '('){
                stack.push(ch);
            }
            // closing bracket
            else {
                if (stack.size() > 0 && stack.peek() == '('){  // Valid Parentheses
                    stack.pop();
                }else {
                    stack.push(ch);  // inValid Parentheses
                }
            }
        }

        while(!stack.isEmpty()){
            char c1 = stack.pop();
            char c2 = stack.pop();

            if (c1 == c2) {   // reversing only 1 bracket
                count++;
            }
            else{     // reversing both brackets
                count += 2;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(countBracketReversals(input));
    }

}
------------------
        Input:
        }{

        Output:
        2
        -----------------
        Input:
        {{{}}{{

        Output:
        -1

        ***********************

public static int addMinimumParentheses(String str){

        // Creating Stack of Character type
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++){
        char ch = str.charAt(i);

        // Opening bracket
        if (ch == '('){
        stack.push(ch);
        }
        // closing bracket
        else {
        if (stack.size() > 0 && stack.peek() == '('){  // Valid Parentheses
        stack.pop();
        }else {
        stack.push(ch);  // inValid Parentheses
        }
        }
        }
        return stack.size();
        }

public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println(addMinimumParentheses(str));
        }
        }


        Input:
        (((((
        Output:
        5
        Input:
        ))(
        Output:
        3