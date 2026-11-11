
class Solution {
    int[][][] dp;
    int n;

    public int cherryPickup(int[][] grid) {
        n = grid.length;

        dp = new int[n][n][n];

        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, Integer.MIN_VALUE);
            }
        }

        return Math.max(0, solve(0, 0, 0, grid));
    }

    int solve(int r1, int c1, int r2, int[][] grid) {

        int c2 = r1 + c1 - r2;

        // Out of bounds
        if (r1 >= n || c1 >= n ||
            r2 >= n || c2 >= n) {
            return -1000000;
        }

        // Thorn
        if (grid[r1][c1] == -1 ||
            grid[r2][c2] == -1) {
            return -1000000;
        }

        // Destination reached
        if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }

        if (dp[r1][c1][r2] != Integer.MIN_VALUE) {
            return dp[r1][c1][r2];
        }

        // Four possible movements
        int a = solve(r1 + 1, c1, r2 + 1, grid);
        int b = solve(r1 + 1, c1, r2, grid);
        int c = solve(r1, c1 + 1, r2 + 1, grid);
        int d = solve(r1, c1 + 1, r2, grid);

        int cherries = Math.max(
            Math.max(a, b),
            Math.max(c, d)
        );

        // Count cherries only once if same cell
        int current = grid[r1][c1];

        if (r1 != r2 || c1 != c2) {
            current += grid[r2][c2];
        }

        return dp[r1][c1][r2] = current + cherries;
    }
}
