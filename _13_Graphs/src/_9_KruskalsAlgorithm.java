public class _9_KruskalsAlgorithm {
}
Q.  Code : Kruskal's Algorithm
        -----------------------------------------
        Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.
        Find and print the Minimum Spanning Tree (MST) using Kruskal's algorithm.
        -----------------------------------------
        For printing MST follow the steps -

        1. In one line, print an edge which is part of MST in the format -
        v1 v2 w
        where, v1 and v2 are the vertices of the edge which is included in MST and whose weight is w. And v1  <= v2 i.e. print the smaller vertex first while printing an edge.

        2. Print V-1 edges in above format in different lines.
        ----------------------------------------
        Note : Order of different edges doesn't matter.
        ----------------------------------------
        Input Format :
        Line 1: Two Integers V and E (separated by space)
        Next E lines : Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and vertex ej with weight wi (separated by space)

        Output Format :
        Print the MST, as described in the task.
        ----------------------------------------
        Create Project: Graphs

        Create Pakage: Default

        Create class: Kruskal
        -----------------------------------------
        import java.util.Arrays;
        import java.util.Scanner;

class Edge implements Comparable<Edge>{
    int source;
    int dest;
    int weight;

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;   // for sorting in icreasing order
    }
}

public class Kruskal {

    // Creating function findParent whose work is to find the topMost parent of given vertex
    public static int findParent(int vertex, int parent[]){
        if (parent[vertex] == vertex) {
            return vertex;
        }
        return findParent(parent[vertex], parent);
    }

    public static void kruskals(Edge input[], int n){

        // Sorting the array based on weight by implementing an interface comparable
        Arrays.sort(input);

        // Creating storage output of (totalNoOfVertices - 1) size
        Edge output[] = new Edge[n - 1];

        // Initializing parent array (Same as index) for identifying the final parent of edge between two vertices
        int parent[] = new int[n];
        for (int i = 0; i < n; i++){
            parent[i] = i;
        }

        int count = 0;  // for representing no. of edges which have gone into output (MST)
        int i = 0;    // for representing at which edges of input array, we are working

        while (count != n - 1){

            Edge currentEdge = input[i];

            // Checking currentEdge before adding into output by figuring out both vertexParent of currentEdge (cycle exiting or not)
            int sourceParent = findParent(currentEdge.source, parent);
            int destParent = findParent(currentEdge.dest, parent);

            // Checking value of vertexParent
            if (sourceParent != destParent){
                output[count] = currentEdge;
                count++;

                // Making anyone of two vertices as parent and anyone of two vertices as child
                parent[sourceParent] = destParent;
            }

            // We have to update 'i' irrespective of above if condition
            i++;
        }

        for (int j = 0; j < n - 1; j++){
            if (output[j].source < output[j].dest){
                System.out.println(output[j].source + " " + output[j].dest + " " + output[j].weight);
            }else {
                System.out.println(output[j].dest + " " + output[j].source + " " + output[j].weight);
            }
        }
    }


    public static void main(String[] args) {

        // Taking Inputs:
        Scanner scn = new Scanner(System.in);
        int totalNoOfVertices = scn.nextInt();
        int totalNoOfEdges = scn.nextInt();

        // Creating array of edge type
        Edge input[] = new Edge[totalNoOfEdges];

        for (int i = 0; i < totalNoOfEdges; i++){
            input[i] = new Edge();                  // Initially null is stored in array

            input[i].source = scn.nextInt();
            input[i].dest = scn.nextInt();
            input[i].weight = scn.nextInt();
        }
        kruskals(input, totalNoOfVertices);
    }
}

----------------------------------------------------

        Input:
        6 11
        0 1 2
        0 2 4
        2 3 6
        1 3 1
        0 3 3
        1 2 8
        2 4 9
        4 5 5
        3 5 7
        2 5 10
        3 4 11

        Output:
        1 3 1
        0 1 2
        0 2 4
        4 5 5
        3 5 7
