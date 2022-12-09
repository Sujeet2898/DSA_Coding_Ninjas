public class _10_PrimAlgorithm {
}
Q.  Code : Prim's Algorithm
        -----------------------------------------
        Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.
        Find and print the Minimum Spanning Tree (MST) using Prim's algorithm.
        -----------------------------------------
        Present Time Complexity: O(V^2)

        Improved Time Complexity: Olog(V+E) if we use priority queue O(logn) for finding minVertex & adjacency list O(logn) in place of adjacency matrix
        ----------------------------------------
        For printing MST follow the steps -

        1. In one line, print an edge which is part of MST in the format -
        v1 v2 w
        where, v1 and v2 are the vertices of the edge which is included in MST and whose weight is w. And v1  <= v2 i.e. print the smaller vertex first while printing an edge.

        2. Print V-1 edges in above format in different lines.
        -----------------------------------------
        Note : Order of different edges doesn't matter.
        -----------------------------------------
        Input Format :
        Line 1: Two Integers V and E (separated by space)
        Next E lines : Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and vertex ej with weight wi (separated by space)

        Output Format :
        Print the MST, as described in the task.
        -----------------------------------------
        Create Project: Graphs

        Create Pakage: Default

        Create class: Prims
        -----------------------------------------
        import java.util.Scanner;

public class Prims {

    private static void prims(int[][] adjacencyMatrix) {
        int totalNoOfVertices = adjacencyMatrix.length;

        // Creating 3 arrays of size 'totalNoOfVertices'
        boolean visited[] = new boolean[totalNoOfVertices];
        int weight[] = new int[totalNoOfVertices];
        int parent[] = new int[totalNoOfVertices];

        weight[0] = 0;
        parent[0] = -1;

        // Initializing weights of all vertices as infinity except 0
        for (int i = 1; i < totalNoOfVertices; i++){
            weight[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < totalNoOfVertices; i++){

            // Pick vertex with min weight
            int minVertex = findMinVertex(weight, visited);
            visited[minVertex] = true;

            // Explore its unVisited neighbors
            for (int j = 0; j < totalNoOfVertices; j++){
                if (adjacencyMatrix[minVertex][j] != 0 && !visited[j]){

                    // Updating weight & parent of neighbour
                    if (adjacencyMatrix[minVertex][j] < weight[j]) {
                        weight[j] = adjacencyMatrix[minVertex][j];
                        parent[j] = minVertex;
                    }
                }
            }
        }

        // Print edges of MST (Minimum Spanning Tree)
        for (int i = 1; i < totalNoOfVertices; i++){
            if (parent[i] < i){
                System.out.println(parent[i] + " " + i + " " + weight[i]);
            }else {
                System.out.println(i + " " +  parent[i] + " " + weight[i]);
            }
        }
    }

    private static int findMinVertex(int[] weight, boolean[] visited) {
        int minVertex = -1;
        for (int i = 0; i < weight.length; i++){
            if (!visited[i] && (minVertex == -1 || weight[i] < weight[minVertex])){
                minVertex = i;
            }
        }
        return minVertex;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int totalNoOfVertices = scn.nextInt();
        int totalNoOfEdges = scn.nextInt();
        int adjacencyMatrix[][] = new int[totalNoOfVertices][totalNoOfVertices];
        for (int i = 0; i < totalNoOfEdges; i++){
            int firstVertex = scn.nextInt();
            int secondVertex = scn.nextInt();
            int weight = scn.nextInt();
            adjacencyMatrix[firstVertex][secondVertex] = weight;
            adjacencyMatrix[secondVertex][firstVertex] = weight;
        }
        prims(adjacencyMatrix);
    }
}
------------------------------------------------
        Input:
        5 7
        0 1 4
        0 2 8
        1 2 2
        1 3 6
        3 4 5
        2 4 9
        2 3 3

        Output:
        0 1 4
        1 2 2
        2 3 3
        3 4 5
