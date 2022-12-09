public class _3_BFSTraversal {
}
Q.  Code : BFS Traversal
        ---------------------------------------------------------------
        Given an undirected and disconnected graph G(V, E), print its BFS traversal.
        ---------------------------------------------------------------
        Note:
        1. Here you need to consider that you need to print BFS path starting from vertex 0 only.
        2. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
        3. E is the number of edges present in graph G.
        4. Take graph input in the adjacency matrix.
        5. Handle for Disconnected Graphs as well
        ---------------------------------------------------------------
        Input Format :
        The first line of input contains two integers, that denote the value of V and E.
        Each of the following E lines contains space separated two integers, that denote that there exists an edge between vertex a and b.
        Output Format :
        Print the BFS Traversal, as described in the task.
        ---------------------------------------------------------------
        import java.util.LinkedList;
        import java.util.Queue;
        import java.util.Scanner;

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

        boolean visited[] = new boolean[edges.length];
        for (int i = 0; i < edges.length; i++){
            if (!visited[i]){
                printBFSHelper(edges,i,visited);
            }
        }
    }

    public static void printBFSHelper(int edges[][], int startingVertex, boolean visited[]){
        Queue<Integer> queue =  new LinkedList<>();

        // Adding startingVertex into Queue
        queue.add(startingVertex);

        // As soon as something is going into the queue, we should marked it as visited
        visited[startingVertex] = true;

        // Work : As long as Queue is not empty
        while (!queue.isEmpty()){
            int front;


            // Work 1 : Removing frontNode from the Queue
            front = queue.remove();


            // Work 2 : Printing the Removed frontNode
            System.out.print(front + " ");

            // Work 3 : Adding whatever adjacent to startingVertex into the queue
            for (int i = 0; i < edges.length; i++){
                if (edges[front][i] == 1 && !visited[i]){
                    queue.add(i);

                    // As soon as something is going into the queue, we should marked it as visited
                    visited[i] =true;
                }
            }
        }
    }
}
-----------------------------------------------------
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
        0 1 2 3 4
