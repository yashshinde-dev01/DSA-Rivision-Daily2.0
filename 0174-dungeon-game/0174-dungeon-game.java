class Solution {
    int m, n;
    int[][] dp;

    public int calculateMinimumHP(int[][] dungeon) {
        m = dungeon.length;
        n = dungeon[0].length;

        int left = 1;
        int right = 1;

        for (int[] row : dungeon) {
            for (int val : row) {
                if (val < 0) {
                    right -= val;
                }
            }
        }

        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            dp = new int[m][n];

            if (canSurvive(dungeon, 0, 0, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    boolean canSurvive(int[][] arr, int i, int j, int health) {

        if (i >= m || j >= n) {
            return false;
        }

        health += arr[i][j];

        if (health <= 0) {
            return false;
        }

        if (i == m - 1 && j == n - 1) {
            return true;
        }

        // Memoization / pruning
        if (dp[i][j] >= health) {
            return false;
        }

        dp[i][j] = health;

        return canSurvive(arr, i, j + 1, health) ||
               canSurvive(arr, i + 1, j, health);
    }
}