public class _2_SumOfNaturalNumbers {
}

    Recusion follow "Principal of Mathematical Induction (PMI)"
        1. Base case is coorect.
        2. Smaller problem is correct which is similar to Induction Hypothesis of PMI.
        3. Final calculation part is correct i.e if smaller problem is correct, then bigger problem should be supposed to be correct.
        -------------------------------------------

        Create Project: Recursion

        Create Package: Default

        Create class: SumOfNaturalNumbers
        -----------------------------------------
public class SumOfNaturalNumbers {

    public static int sum(int n) {
        if (n == 1) {                     // base case
            return 1;
        }
        return sum(n - 1) + n;           // sum(n -1) is Induction Hypothesis
    }                                    // sum(n - 1) + n i.e final calculation is also correct

    public static void main(String[] args){
        int n = 4;
        System.out.println(sum(n));
    }
}
----------------------
        output:
        10