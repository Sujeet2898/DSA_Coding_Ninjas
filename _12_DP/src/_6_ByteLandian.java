public class _6_ByteLandian {
}
    Q.  Byte Landian
-----------------------------------------------
        Byteland has a very strange monetary system.
        Each Bytelandian gold coin has an integer number written on it. A coin n can be exchanged in a bank into three coins: n/2, n/3 and n/4. But these numbers are all rounded down (the banks have to make a profit).
        You can also sell Bytelandian coins for American dollars. The exchange rate is 1:1. But you can not buy Bytelandian coins.
        You have one gold coin. What is the maximum amount of American dollars you can get for it?
        -----------------------------------------------
        Examples:-
        Input 1 :
        12
        Output 1 :
        13
        Explanation of Output 1 :
        You can change 12 into 6, 4 and 3, and then change these into $6 + $4 + $3 = $13.

        Input 2 :
        2
        Output 1 :
        2
        Explanation of Output 2 :
        If you try changing the coin 2 into 3 smaller coins, you will get 1, 0 and 0, and later you can get no more than $1 out of them. It is better just to change the 2 coin directly into $2.
        -----------------------------------------------
        Create Project: Dynamic Programming

        Create Package: default

Create class: ByteLandian
        -----------------------------------------------
public class ByteLandian {

    public static long bytelandian(long n, HashMap<Long, Long> map){
        if (n == 0 || n == 1){
            return n;
        }
        if (map.containsKey(n)){
            return map.get(n);
        }
        long max = Math.max(n, bytelandian(n/2,map) + bytelandian(n/3,map) + bytelandian(n/4,map));

        map.put(n, max);

        return max;
    }

    public static void main(String[] args) {
        HashMap<Long,Long> map = new HashMap();
        int n = 20;
        System.out.println(bytelandian(n,map));
    }
}
----------------------------------------------
        Output:
        21
