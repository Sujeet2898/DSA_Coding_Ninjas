public class _3_FibonacciNumber {
}

        n=0 -> 0
        n=1 -> 1
        n=2 -> 1
        n=3 -> 2
        n=4 -> 3
        n=5 -> 5
        n=6 -> 8
        n=7 -> 13

        -------------------------------
        Create Project: Recursion

        Create Package: Default

        Create class: Factorial
        -----------------------------------------
public class FibonacciNumber {

    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(fib(n));
    }
}
----------------------
        output:
        5