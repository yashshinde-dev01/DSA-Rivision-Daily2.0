class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(grid, 0, 0, m - 1, dp);
    }

    public int solve(int[][] grid, int row, int col1,
                     int col2, int[][][] dp) {

        int n = grid.length;
        int m = grid[0].length;

        // Invalid columns
        if (col1 < 0 || col1 >= m ||
            col2 < 0 || col2 >= m) {
            return Integer.MIN_VALUE;
        }

        // Base case
        if (row == n - 1) {
            if (col1 == col2) {
                return grid[row][col1];
            }
            return grid[row][col1] + grid[row][col2];
        }

        if (dp[row][col1][col2] != -1) {
            return dp[row][col1][col2];
        }

        // Current cherries
        int cherries = grid[row][col1];

        if (col1 != col2) {
            cherries += grid[row][col2];
        }

        int maxi = Integer.MIN_VALUE;

        // 9 possible movements
        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {

                int next1 = col1 + d1;
                int next2 = col2 + d2;

                int ans = solve(grid, row + 1,
                                next1, next2, dp);

                maxi = Math.max(maxi, ans);
            }
        }

        return dp[row][col1][col2] = cherries + maxi;
    }
}