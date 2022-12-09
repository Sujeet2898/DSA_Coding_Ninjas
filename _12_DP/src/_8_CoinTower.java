public class _8_CoinTower {
}
    Q.  Coin Tower
-----------------------------------------------
        Whis and Beerus are playing a new game today. They form a tower of N coins and make a move in alternate turns. Beerus plays first. In one step, the player can remove either 1, X, or Y coins from the tower. The person to make the last move wins the game. Can you find out who wins the game?
        -----------------------------------------------
        Input format :
        The first and the only line of input contains three integer values separated by a single space. They denote the value of N, X and Y, respectively.

        Output format :
        Prints the name of the winner, either 'Whis' or 'Beerus' (Without the quotes).
        -----------------------------------------------
        Create Project: Dynamic Programming

        Create Package: default

Create class: CoinTower
        -----------------------------------------------
public class CoinTower {

    /*   Time Complexity: O(n) by using Dynamic Programming   */

    public static String findWinnerDP(int n, int x, int y) {

        // Our target is to store result in a storageArray
        int[] storage = new int[n + 1];

        // Entry corresponding to baseCase
        storage[1] = 1;
        storage[x] = 1;
        storage[y] = 1;

        // "for" loop for next entries
        for (int i = 2; i <=n; i++) {
            if (storage[i] == 0) {

                // (^)-> Binary XOR:  0^0=0; 1^1=0; 1^0=1; 0^1=1  (Similar value- False , Different value- True)
                storage[i] = storage[i - 1] ^ 1;    // should be false

                if (i - x >= 1) {
                    storage[i] = Math.max(storage[i], storage[i - x]^1);    // should be false
                }
                if (i - y >= 1) {
                    storage[i] = Math.max(storage[i], storage[i - y]^1);     // should be false
                }
            }
        }
        if (storage[n] != 0) {
            return "Beerus";
        }
        else {
            return "Whis";
        }
    }

    public static void main(String[] args) {
        int n = 10;
        int x = 2;
        int y = 3;
        System.out.println(findWinnerDP(n, x, y));
    }
}
-------------------------------------------------
        Output:
        Beerus
