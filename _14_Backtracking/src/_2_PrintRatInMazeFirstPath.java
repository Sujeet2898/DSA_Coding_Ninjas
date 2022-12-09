public class _2_PrintRatInMazeFirstPath {
}
Q.  Code: Print Rat In a Maze First Path
        ----------------------------------------
        You are given a N*N maze with a rat placed at maze[0][0]. Find and print first path that rat can follow to reach its destination i.e. maze[N-1][N-1]. Rat can move in any direction ( left, right, up and down).
        Value of every cell in the maze can either be 0 or 1. Cells with value 0 are blocked means rat cannot enter into those cells and those with value 1 are open.
        ----------------------------------------
        Create Project: Backtracking

        Create Pakage: Default

        Create class: RatInAMaze
        -----------------------------------------

        public class RatInAMaze {

        private static boolean ratInAMaze(int[][] maze) {
        int n = maze.length;
        int path[][] = new int[n][n];
        return solveMaze(maze,0,0,path);
        }

        private static boolean solveMaze(int[][] maze, int i, int j, int[][] path) {
        int n = maze.length;

        // Check if i,j cell is valid or not
        if (i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1){     // maze[i][j] == 0 -> cell is blocked
        return false;                                                                  // path[i][j] == 1 -> cell is already visited
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
        return true;
        }

        // Explore further in all directions
        // Top
        if (solveMaze(maze, i - 1, j, path)){
        return true;
        }
        // Right
        if (solveMaze(maze, i, j + 1, path)){
        return true;
        }
        // Down
        if (solveMaze(maze, i + 1, j, path)){
        return true;
        }
        // Left
        if (solveMaze(maze, i , j - 1, path)){
        return true;
        }
        return false;
        }

        public static void main(String[] args) {
        int maze[][] = {{1,1,0}, {1,1,0}, {1,1,1}};
        boolean pathPossible = ratInAMaze(maze);
        System.out.println(pathPossible);
        }
        }
        -----------------------------------------
        Output:
        1 1 0
        0 1 0
        0 1 1
        true
