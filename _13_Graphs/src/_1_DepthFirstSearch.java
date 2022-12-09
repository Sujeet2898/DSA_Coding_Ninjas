public class _1_DepthFirstSearch {
}
    Create Project: Graphs

        Create Pakage: Default

        Create class: Graph
        -----------------------------------------
        import java.util.Scanner;

public class Graph {

    public static void printHelper(int edges[][], int startingVertex, boolean visited[]){
        System.out.println(startingVertex);
        visited[startingVertex] = true;
        for (int i = 0; i < edges.length; i++){
            if (edges[startingVertex][i] == 1 && !visited[i]){
                printHelper(edges, i, visited);  // i become startingVertex
            }
        }
    }

    public static void print(int edges[][]){
        boolean visited[] = new boolean[edges.length];

        // Traversing each disconnected graph
        for (int i = 0; i < edges.length; i++) {
            if (!visited[i]) {
                printHelper(edges, i, visited);
            }
        }
    }

    public static void main(String[] args) {
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
        print(edges);
    }
}
----------------------------------------------------
        Graph:
        0      3
        / \      \
        1 - 2      4
        Input:
        5
        4
        0 1
        1 2
        0 2
        3 4

        Output:
        0
        1
        2
        3
        4