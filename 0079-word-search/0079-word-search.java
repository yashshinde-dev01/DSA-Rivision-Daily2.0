class Solution {

    int[][] dire = {
        {1, 0},   // Down
        {-1, 0},  // Up
        {0, 1},   // Right
        {0, -1}   // Left
    };

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        boolean[][] visi = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0, visi)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word,
                        int row, int col, int index,
                        boolean[][] visi) {

        // Boundary check
        if (row < 0 || col < 0 ||
            row >= board.length || col >= board[0].length) {
            return false;
        }

        // Already visited or character mismatch
        if (visi[row][col] ||
            board[row][col] != word.charAt(index)) {
            return false;
        }

        // Entire word found
        if (index == word.length() - 1) {
            return true;
        }

        // Mark visited
        visi[row][col] = true;

        // Explore all four directions
        for (int[] d : dire) {
            int newRow = row + d[0];
            int newCol = col + d[1];

            if (dfs(board, word, newRow, newCol, index + 1, visi)) {
                visi[row][col] = false;
                return true;
            }
        }

        // Backtracking
        visi[row][col] = false;

        return false;
    }
}