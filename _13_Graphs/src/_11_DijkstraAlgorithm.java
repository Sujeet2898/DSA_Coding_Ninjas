public class _11_DijkstraAlgorithm {
}
Code : Dijkstra's Algorithm
        ----------------------------------------
        Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.
        Find and print the shortest distance from the source vertex (i.e. Vertex 0) to all other vertices (including source vertex also) using Dijkstra's Algorithm.
        ----------------------------------------
        Present Time Complexity: O(V^2)

        Improved Time Complexity: Olog(V+E) if we use priority queue O(logn) for finding minVertex & adjacency list O(logn) in place of adjacency matrix
        ----------------------------------------
        Input Format :

        Line 1: Two Integers V and E (separated by space)

        Next E lines : Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and vertex ej with weight wi (separated by space)

        Output Format :

        For each vertex, print its vertex number and its distance from source, in a separate line. The vertex number and its distance needs to be separated by a single space.
        -----------------------------------------
        Note : Order of vertices in output doesn't matter.
        -----------------------------------------
        Create Project: Graphs

        Create Pakage: Default

        Create class: Dijkstra
        -----------------------------------------
        import java.util.Scanner;

public class Dijkstra {

    private static void dijkstra(int[][] adjacencyMatrix) {
        int totalNoOfVertices = adjacencyMatrix.length;

        // Creating 2 arrays of size 'totalNoOfVertices'
        boolean visited[] = new boolean[totalNoOfVertices];
        int distance[] = new int[totalNoOfVertices];

        distance[0] = 0;
        // Initializing weights of all vertices as infinity except 0
        for (int i = 1; i < totalNoOfVertices; i++){
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < totalNoOfVertices - 1; i++){

            // Find vertex with min distance
            int minVertex = findMinVertex(distance, visited);
            visited[minVertex] = true;

            // Explore its unVisited neighbors
            for (int j = 0; j < totalNoOfVertices; j++){
                if (adjacencyMatrix[minVertex][j] != 0 && !visited[j] && distance[minVertex] != Integer.MAX_VALUE){
                    int newDistance = distance[minVertex] + adjacencyMatrix[minVertex][j];
                    // Updating distance of neighbour
                    if (newDistance < distance[j]) {
                        distance[j] = newDistance;
                    }
                }
            }
        }

        // Print edges of MST (Minimum Spanning Tree)
        for (int i = 0; i < totalNoOfVertices; i++){
            System.out.println(i + " " + distance[i]);
        }
    }

    private static int findMinVertex(int[] distance, boolean[] visited) {
        int minVertex = -1;
        for (int i = 0; i < distance.length; i++){
            if (!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex])){
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
            int distance = scn.nextInt();
            adjacencyMatrix[firstVertex][secondVertex] = distance;
            adjacencyMatrix[secondVertex][firstVertex] = distance;
        }
        dijkstra(adjacencyMatrix);
    }
}
------------------------------------------------
        Input:
        5 7
        0 1 4
        0 2 8
        1 3 5
        1 2 2
        2 3 5
        2 4 9
        3 4 4

        Output:
        0 0
        1 4
        2 6
        3 9
        4 13
