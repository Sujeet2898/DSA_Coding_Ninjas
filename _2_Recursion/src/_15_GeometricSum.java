public class _15_GeometricSum {
}

    Geometric Sum
--------------
        Given k, find the geometric sum i.e.
        1 + 1/2 + 1/4 + 1/8 + ... + 1/(2^k)
        using recursion.

        Input format :
        Integer k

        Output format :
        Geometric sum (upto 5 decimal places)
        -------------------------------------

        Create Project: Recursion

        Create Package: Default

        Create class:  GeometricSum
        -----------------------------------------
        import java.util.*;
public class GeometricSum {

    public static double findGeometricSum(int k){

        if(k==0){
            return 1;
        }

        double smallAns = findGeometricSum(k-1);
        double ans = smallAns + 1/(Math.pow(2,k));
        return ans;

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        System.out.println(findGeometricSum(k));
    }
}
--------------------
        Input:
        4

        Output:
        1.9375