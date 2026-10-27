
class Solution {

    int[][] dire = {
        {1, 0},   // Down
        {-1, 0},  // Up
        {0, 1},   // Right
        {0, -1}   // Left
    };

    int count = 0;

    public int uniquePathsIII(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int startRow = 0;
        int startCol = 0;
        int total = 0;

        // Find starting cell and count walkable cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] != -1) {
                    total++;
                }

                if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        dfs(grid, startRow, startCol, 0, total);

        return count;
    }

    private void dfs(int[][] grid,
                     int row, int col, int visited,
                     int total) {

        // Boundary check
        if (row < 0 || col < 0 ||
            row >= grid.length || col >= grid[0].length) {
            return;
        }

        // Obstacle or already visited
        if (grid[row][col] == -1) {
            return;
        }

        // Reached destination
        if (grid[row][col] == 2) {
            if (visited + 1 == total) {
                count++;
            }
            return;
        }

        // Mark current cell visited
        grid[row][col] = -1;

        // Explore all four directions
        for (int[] d : dire) {
            int newRow = row + d[0];
            int newCol = col + d[1];

            dfs(grid, newRow, newCol,
                visited + 1, total);
        }

        // Backtracking
        grid[row][col]=0;
    }
}
