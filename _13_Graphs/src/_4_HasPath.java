public class _4_HasPath {
}
Q.  Code : Has Path
        -------------------------------------------------------
        Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers), check if there exists any path between them or not. Print true if the path exists and false otherwise.
        ------------------------------------------------------
        Note:
        1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
        2. E is the number of edges present in graph G.
        ------------------------------------------------------
        Input Format :
        The first line of input contains two integers, that denote the value of V and E.
        Each of the following E lines contains two integers, that denote that there exists an edge between vertex 'a' and 'b'.
        The following line contain two integers, that denote the value of v1 and v2.

        Output Format :
        The first and only line of output contains true, if there is a path between v1 and v2 and false otherwise.
        ------------------------------------------------------
        import java.util.LinkedList;
        import java.util.Queue;
        import java.util.Scanner;
        import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
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

        int start = scn.nextInt();
        int end = scn.nextInt();
        boolean visited[] = new boolean[edges.length];
        printBFSHelper(edges,start,end,visited);
    }

    public static void printBFSHelper(int edges[][], int start, int end, boolean visited[]){
        Queue<Integer> queue =  new LinkedList<>();

        // Adding startingVertex into Queue
        queue.add(start);

        // As soon as something is going into the queue, we should marked it as visited
        visited[start] = true;

        // Work : As long as Queue is not empty
        while (!queue.isEmpty()){

            // Work 1 : Removing frontNode from the Queue
            int front = queue.remove();

            // Work 2 : Printing the Removed frontNode
            if(front == end){
                System.out.print("true");
                return;
            }

            // Work 3 : Adding whatever adjacent to startingVertex into the queue
            for (int i = 0; i < edges.length; i++){
                if (edges[front][i] == 1 && !visited[i]){
                    queue.add(i);

                    // As soon as something is going into the queue, we should marked it as visited
                    visited[i] = true;
                }
            }
        }
        System.out.print("false");
    }

}
---------------------------------------------
        Input:
        4 4
        0 1
        0 3
        1 2
        2 3
        1 3

        Output:
        true
        ---------

        Input:
        6 3
        5 3
        0 1
        3 4
        0 3

        Output:
        false
