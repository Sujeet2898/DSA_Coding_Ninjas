public class _5_GetPathDFS {
}
Q.  Code : Get Path - DFS
        ----------------------------------------------------
        Given an undirected graph G(V, E) and two vertices v1 and v2(as integers), find and print the path from v1 to v2 (if exists). Print nothing if there is no path between v1 and v2.
        Find the path using DFS and print the first path that you encountered.
        ----------------------------------------------------
        Note:
        1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
        2. E is the number of edges present in graph G.
        3. Print the path in reverse order. That is, print v2 first, then intermediate vertices and v1 at last.
        4. Save the input graph in Adjacency Matrix.
        ----------------------------------------------------
        Input Format :
        The first line of input contains two integers, that denote the value of V and E.
        Each of the following E lines contains two integers, that denote that there exists an edge between vertex 'a' and 'b'.
        The following line contain two integers, that denote the value of v1 and v2.
        Output Format :
        Print the path from v1 to v2 in reverse order.
        ----------------------------------------------------
        import java.util.ArrayList;
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
        int start = scn.nextInt();
        int end  = scn.nextInt();
        boolean[] visited = new boolean[edges.length];
        ArrayList<Integer> ans = getPath(edges, start, end, visited);
        if(ans!=null)
            for(int i : ans) {
                System.out.print(i+" ");
            }
    }

    public static ArrayList<Integer> getPath( int[][] edges ,int start ,int end, boolean[] visited){
        if(start == end) {
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(start);
            return ans;
        }

        visited[start] = true;
        for(int i=0;i<edges.length;i++) {

            if(edges[start][i]==1 && !visited[i]) {

                ArrayList<Integer> ans = getPath(edges, i, end, visited);
                if(ans!=null) {
                    ans.add(start);
                    return ans;
                }
            }
        }
        return null;
    }
}
---------------------------------------------------------
        Input:
        9 10
        0 8
        1 6
        1 7
        1 8
        5 8
        6 0
        7 3
        7 4
        8 7
        2 5
        3 8
        Output:
        8 0 6 1 7 3

        Input:
        4 4
        0 1
        0 3
        1 2
        2 3
        1 3
        Output:
        3 0 1