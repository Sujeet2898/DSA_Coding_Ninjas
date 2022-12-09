public class _7_IsConnected {
}
Q.  Code : Is Connected ?
        -------------------------------------------------
        Given an undirected graph G(V,E), check if the graph G is connected graph or not.
        -------------------------------------------------
        Note:
        1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
        2. E is the number of edges present in graph G.
        -------------------------------------------------
        Input Format :
        The first line of input contains two integers, that denote the value of V and E.
        Each of the following E lines contains two integers, that denote that there exists an edge between vertex a and b.

        Output Format :
        The first and only line of output contains "true" if the given graph is connected or "false", otherwise.
        -------------------------------------------------

        import java.util.Scanner;
        import java.util.LinkedList;
        import java.util.Queue;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {

        Scanner scn = new Scanner(System.in);
        int noOfVertices = scn.nextInt();
        int noOfEdges = scn.nextInt();
        int edges[][] = new int[noOfVertices][noOfVertices];  // Each cell is 0 by default

        // Taking two vertices & making edge; single edge between two vertices is denoted as 1
        for (int i = 0; i < noOfEdges; i++){
            int firstVertex = scn.nextInt();
            int secondVertex = scn.nextInt();
            edges[firstVertex][secondVertex] = 1;
            edges[secondVertex][firstVertex] = 1;
        }

        // must have for getting rid of indexOutOfBoundException
        if(noOfVertices == 0){
            System.out.println("true");
            return;
        }

        boolean visited[] = new boolean[edges.length];
        System.out.println(isConnected(edges,0,visited));
    }

    public static boolean isConnected(int edges[][], int startingVertex, boolean visited[]){
        Queue<Integer> queue = new LinkedList<>();

        // Adding startingVertex into Queue
        queue.add(startingVertex);

        // As soon as something is going into the queue, we should marked it as visited
        visited[startingVertex] = true;

        // Work : As long as Queue is not empty
        while (!queue.isEmpty()){
            int front = queue.remove();

            for (int i = 0; i < edges.length; i++){
                if (edges[front][i] == 1 && !visited[i]){
                    queue.add(i);

                    // As soon as something is going into the queue, we should marked it as visited
                    visited[i] = true;
                }
            }
        }

        for(boolean b : visited) {
            if(!b) {
                return false;
            }
        }
        return true;
    }

}
-------------------------------------------------------
        Input:
        4 4
        0 1
        0 3
        1 2
        2 3
        Output:
        true

        Input:
        4 3
        0 1
        1 3
        0 3
        Output:
        false
