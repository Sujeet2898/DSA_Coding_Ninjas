public class _6_GetPathBFS {
}
Q.  Code : Get Path - BFS
        ---------------------------------------------------
        Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers), find and print the path from v1 to v2 (if exists). Print nothing if there is no path between v1 and v2.
        Find the path using BFS and print the shortest path available.
        ---------------------------------------------------
        Note:
        1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
        2. E is the number of edges present in graph G.
        3. Print the path in reverse order. That is, print v2 first, then intermediate vertices and v1 at last.
        4. Save the input graph in Adjacency Matrix.
        ---------------------------------------------------
        Input Format :
        The first line of input contains two integers, that denote the value of V and E.
        Each of the following E lines contains two integers, that denote that there exists an edge between vertex a and b.
        The following line contain two integers, that denote the value of v1 and v2.
        Output Format :
        Print the path from v1 to v2 in reverse order.
        ----------------------------------------------------
        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.LinkedList;
        import java.util.Queue;
        import java.util.Scanner;

public class Solution {

    public static void main(String[] args)  throws NumberFormatException, IOException{
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
        int end  = scn.nextInt();
        boolean[] visited = new boolean[edges.length];
        ArrayList<Integer> ans = getPath(edges, start, end, visited);
        if(ans!=null)
            for(int i : ans) {
                System.out.print(i+" ");
            }
    }

    public static ArrayList<Integer> getPath(int[][] edges,int start,int end,boolean[] visited){

        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        queue.add(start);
        visited[start] = true;
        while( !queue.isEmpty() && queue.peek()!=end) {

            int front = queue.remove();
            for(int i=0;i<edges.length;i++) {
                if(edges[front][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    map.put(i, front);
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        if(!map.containsKey(end)) {
            return null;
        }
        else {
            ans.add(end);
            int value = map.get(end);
            while(value!=start) {
                ans.add(value);
                value = map.get(value);
            }
            ans.add(value);
        }
        return ans;
    }
}
---------------------------------------------------------
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
        4 1
        Output:
        1 0 4

        Input:
        4 4
        0 1
        0 3
        1 2
        2 3
        1 3
        Output:
        3 0 1