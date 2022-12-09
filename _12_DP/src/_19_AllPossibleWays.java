public class _19_AllPossibleWays {
}
    Q.  All possible ways
        -----------------------------------------
        Given two integers a and b. You need to find and return the count of possible ways in which we can represent the number a as the sum of unique integers raise to the power b.
        -----------------------------------------
        For example: if a = 10 and b = 2, only way to represent 10 as sum of unique integers raised to power 2 is-
        10 = 1^2 + 3^2
        Hence, answer is 1.
        Note : x^y represents x raise to the power y
        -----------------------------------------
        Create Project: Recursion

        Create Package: Default

        Create class: AllPossibleWays
        -----------------------------------------
public class AllPossibleWays {

    public static int allWays(int x, int n) {
        return allWays(x,n,1);
    }
    private static int allWays(int x, int n,int num) {
        int val = x - (int)Math.pow(num,n);
        if(val==0){
            return 1;
        }
        if(val<0){
            return 0;
        }
        return allWays(x,n,num+1)  + allWays(val,n,num+1);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        System.out.println(allWays(x,n));
    }
}
----------------------
        Input:
        100
        2
        output:
        3

        Following are the three ways:
        1. 100 = 10^2
        2. 100 = 8^2 + 6^2
        3. 100 = 7^2+5^2+4^2+3^2+1^2
