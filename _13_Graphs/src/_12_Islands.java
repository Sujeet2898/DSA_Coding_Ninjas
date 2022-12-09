public class _12_Islands {
}
Q.  Islands
        ----------------------------------------
        An island is a small piece of land surrounded by water . A group of islands is said to be connected if we can reach from any given island to any other island in the same group . Given V islands (numbered from 1 to V) and E connections or edges between islands. Can you count the number of connected groups of islands.
        ----------------------------------------
        Input Format :
        The first line of input contains two integers, that denote the value of V and E.
        Each of the following E lines contains two integers, that denote that there exists an edge between vertex a and b.

        Output Format :
        Print the count the number of connected groups of islands
        ----------------------------------------
public class Solution {

    public static int numConnected(int[][] edges, int n) {
        boolean visited[] = new boolean[edges.length];
        int count = 0;
        // Traversing each disconnected graph
        for (int i = 0; i < edges.length; i++) {
            if (!visited[i]) {
                printHelper(edges, i, visited);
                count++;
            }
        }
        return count;
    }

    public static void printHelper(int edges[][], int startingVertex, boolean visited[]){

        visited[startingVertex] = true;
        for (int i = 0; i < edges.length; i++){
            if (edges[startingVertex][i] == 1 && !visited[i]){
                printHelper(edges, i, visited);  // i become startingVertex
            }
        }
    }
}
---------------------------------------
        Input:
        6 4
        0 1
        0 2
        1 2
        3 4
        Output:
        3

        Input:
        5 8
        0 1
        0 4
        1 2
        2 0
        2 4
        3 0
        3 2
        4 3
        Output:
        1
