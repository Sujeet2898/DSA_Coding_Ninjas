public class _3_RatInMazeAllPaths {
}
Q.  Code: Rat In a Maze All Paths
        ----------------------------------------
        You are given a N*N maze with a rat placed at maze[0][0]. Find and print all paths that rat can follow to reach its destination i.e. maze[N-1][N-1]. Rat can move in any direction ( left, right, up and down).

        Value of every cell in the maze can either be 0 or 1. Cells with value 0 are blocked means rat cannot enter into those cells and those with value 1 are open.
        ----------------------------------------
        Create Project: Backtracking

        Create Pakage: Default

        Create class: PrintAllPaths
        ----------------------------------------

        public class PrintAllPaths {
        private static void ratInAMaze(int[][] maze) {
        int n = maze.length;
        int path[][] = new int[n][n];
        printAllPaths(maze,0,0,path);
        }

        private static void printAllPaths(int[][] maze, int i, int j, int[][] path) {
        int n = maze.length;

        // Check if i,j cell is valid or not
        if (i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1){
        return;
        }

        // Include the cell in current path
        path[i][j] = 1;

        // Destination cell
        if (i == n - 1 && j == n - 1){
        for (int r = 0; r < n; r++){
        for (int c = 0; c < n; c++){
        System.out.print(path[r][c] + " ");
        }
        System.out.println();
        }
        System.out.println();

        // Backtracking each cells of path from 1 to 0 so that other paths can exit
        path[i][j] = 0;
        return;
        }

        // Explore further in all directions recursively
        // Top
        printAllPaths(maze, i - 1, j, path);
        // Right
        printAllPaths(maze, i, j + 1, path);
        // Down
        printAllPaths(maze, i + 1, j, path);
        // Left
        printAllPaths(maze, i , j - 1, path);

        // Backtracking each cells of path from 1 to 0 so that other paths can exit
        path[i][j] = 0;
        }

        public static void main(String[] args) {
        int maze[][] = {{1,1,0}, {1,1,0}, {1,1,1}};
        ratInAMaze(maze);
        }
        }
        -----------------------------------------
        Output:
        1 1 0
        0 1 0
        0 1 1

        1 1 0
        1 1 0
        1 1 1

        1 0 0
        1 1 0
        0 1 1

        1 0 0
        1 0 0
        1 1 1
