import java.util.*;

class Solution {
    public int[][] floodFill(int[][] grid, int sr, int sc, int color) {
        int m = grid.length;
        int n = grid[0].length;

        int originalColor = grid[sr][sc];

        // edge case
        if (originalColor == color) return grid;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        grid[sr][sc] = color;

        int[][] directions = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n 
                    && grid[nr][nc] == originalColor) {

                    grid[nr][nc] = color;
                    queue.add(new int[]{nr, nc});
                }
            }
        }

        return grid;
    }
}