public class _1_Factorial {
}

    Recusion follow "Principal of Mathematical Induction (PMI)"
        1. Base case is coorect.
        2. Smaller problem is correct which is similar to Induction Hypothesis of PMI.
        3. Final calculation part is correct i.e if smaller problem is correct, then bigger problem should be supposed to be correct.
        -------------------------------------------

        Create Project: Recursion

        Create Package: Default

        Create class: Factorial
        -----------------------------------------
public class Factorial {

    public static int fact(int n) {

        if (n == 0) {             // base case
            return 1;
        }

        int smallAns = fact(n - 1);     // smallAns is Induction Hypothesis
        return n * smallAns;            // (n * smallAns) i.e final calculation is also correct
    }
    public static void main(String[] args) {
        int n = 3;
        int ans = fact(n);
        System.out.println(ans);
    }
}
----------------------
        output:
        6