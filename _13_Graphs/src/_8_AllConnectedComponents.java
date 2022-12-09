public class _8_AllConnectedComponents {
}
Q.   Code : All connected components
        ----------------------------------------
        Given an undirected graph G(V,E), find and print all the connected components of the given graph G.
        ----------------------------------------
        Note:
        1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
        2. E is the number of edges present in graph G.
        3. You need to take input in main and create a function which should return all the connected components. And then print them in the main, not inside function.
        Print different components in new line. And each component should be printed in increasing order (separated by space). Order of different components doesn't matter.
        ----------------------------------------
        Input Format :
        The first line of input contains two integers, that denote the value of V and E.
        Each of the following E lines contains two space separated integers, that denote that there exists an edge between vertex a and b.

        Output Format :
        Print different components in new line. And each component should be printed in increasing order of vertices (separated by space). Order of different components doesn't matter.
        ------------------------------------------

        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.LinkedList;
        import java.util.Queue;
        import java.util.*;
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
        boolean[] visited = new boolean[edges.length];
        ArrayList<ArrayList<Integer>> arrayList = connectedComponents(edges);
        for(ArrayList<Integer> row : arrayList) {
            for(int i : row) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }


    public static ArrayList<ArrayList<Integer>> connectedComponents(int[][] edges){

        boolean[] visited = new boolean[edges.length];
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        for(int i=0;i<visited.length;i++) {
            if(!visited[i]) {
                arrayList.add(path(edges, i, visited));
            }
        }
        return arrayList;
    }


    public static ArrayList<Integer> path(int[][] edges,int sv,boolean[] visited){
        ArrayList<Integer> arr = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sv);
        visited[sv] = true;
        while(!queue.isEmpty()) {

            int front = queue.remove();
            arr.add(front);
            for(int i=0;i<edges.length;i++) {

                if(!visited[i] && edges[front][i] ==1) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        Collections.sort(arr);
        return arr;
    }
}
----------------------------------------------
        Input:
        4 2
        0 1
        2 3
        Output:
        0 1
        2 3

        Input:
        4 3
        0 1
        1 3
        0 3
        Output:
        0 1 3
        2