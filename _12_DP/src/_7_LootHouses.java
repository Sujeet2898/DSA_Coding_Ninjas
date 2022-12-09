public class _7_LootHouses {
}
    Q.  Loot Houses
-----------------------------------------------
        A thief wants to loot houses. He knows the amount of money in each house. He cannot loot two consecutive houses. Find the maximum amount of money he can loot.
        -----------------------------------------------
        Example:-
        Input:
        6
        10 2 30 20 3 50
        Output:
        90

        Explanation:
        Looting first, third, and the last houses([10 + 30 + 50]) will result in the maximum loot, and all the other possible combinations would result in less than 90.
        -----------------------------------------------
        Create Project: Dynamic Programming

        Create Package: default

Create class: MinimumCountOfSquares
        -----------------------------------------------
public class MinimumCountOfSquares {

    /*   Time Complexity: O(2^n)    */

    public static int maxMoneyLooted(int[] houses){
        int n = houses.length;
        return getMaxMoney(houses, n);
    }

    private static int getMaxMoney(int arr[], int n){

        // BaseCase
        if(n<=0) {
            return 0;
        }
        return Math.max(getMaxMoney(arr,n-1), arr[n-1] + getMaxMoney(arr,n-2));
    }

    /*   Time Complexity: O(n) by using Memoization Technique    */

    public static int maxMoneyLootedM(int[] houses){
        int n = houses.length;
        return getMaxMoneyM(houses, n);
    }

    private static int getMaxMoneyM(int[] arr,int n) {

        // Making storageArray of n+1 size
        int[] storage = new int[n+1];

        // recursive call
        return getMaxMoneyM(arr, n,storage);
    }

    // Private function for storing result (only unique result to avoid redundancy)
    private static int getMaxMoneyM(int[] arr, int n, int[] storage) {

        // BaseCase
        if(n<=0) {
            storage[0] = 0;
            return storage[0];
        }

        // Checking already calculated value
        if(storage[n]!=0) {
            return storage[n];
        }

        // Storing the newly calculated value in the array to avoid repetition
        storage[n] = Math.max(getMaxMoneyM(arr,n-1,storage), getMaxMoneyM(arr,n-2, storage)+arr[n-1]);
        return storage[n];
    }

    /*   Time Complexity: O(n) by using Dynamic Programming   */

    public static int maxMoneyLootedDP(int[] houses){
        int n = houses.length;
        return getMaxMoneyDP(houses, n);
    }

    public static int getMaxMoneyDP(int arr[], int n){

        // Our target is to store result in a storageArray
        int[] storage = new int[n+1];

        // Entry corresponding to baseCase
        storage[0] = 0;
        storage[1] = arr[0];

        // "for" loop for next entries
        for(int i=2;i<=n;i++) {
            storage[i] = Math.max(storage[i-1] , arr[i-1] + storage[i-2]);
        }
        return storage[n];
    }

    public static void main(String[] args) {
        int arr[] = {5, 5, 10, 100, 10, 5};
        System.out.println(maxMoneyLootedDP(arr));

        System.out.println();

        System.out.println(maxMoneyLootedM(arr));

        System.out.println();

        System.out.println(maxMoneyLooted(arr));
    }
}
--------------------------------------------
        Output:
        110          // Quickly run

        110          // Quickly run

        110          // Take time in running