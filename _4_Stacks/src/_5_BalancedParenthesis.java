public class _5_BalancedParenthesis {
}
Q. Code : Balanced Parenthesis
        ------------------------------
        For a given a string expression containing only round brackets or parentheses, check if they are balanced or not. Brackets are said to be balanced if the bracket which opens last, closes first.
        ------------------------------

        Create Project: Stack

        Create Package: default

Create class: StackCollections
        ------------------------
        import java.util.Stack;
        import java.util.*;

public class StackCollections {

    public static boolean isBalanced(String expression) {

        Stack<Character> stack = new Stack<Character>();
        for (int j = 0; j < expression.length(); j++) {
            char i = expression.charAt(j);
            if (i == '[' || i == '{' || i == '(') {
                stack.push(i);
            } else if (i == ']' || i == '}' || i == ')') {
                if (stack.isEmpty())
                    return false;

                else {
                    if (i == ']') {
                        if (stack.peek() != '[')
                            return false;
                        else
                            stack.pop();
                    } else if (i == '}') {
                        if (stack.peek() != '{')
                            return false;
                        else
                            stack.pop();
                    } else if (i == ')') {
                        if (stack.peek() != '(')
                            return false;
                        else
                            stack.pop();
                    }
                }
            }

        }
        return stack.isEmpty();   // return 'stack.isEmpty()' instead of 'return true' to avoid a few testCase failure
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        System.out.println(isBalanced(expression));
    }
}
------------------
        Input:
        [(){}{{()}}]

        Output:
        true

