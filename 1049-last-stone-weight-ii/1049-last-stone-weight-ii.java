class Solution {
    public int lastStoneWeightII(int[] stones) {

        int totalSum = 0;

        for (int stone : stones) {
            totalSum += stone;
        }

        int target = totalSum / 2;

        boolean[][] dp = new boolean[stones.length + 1][target + 1];

        // Base case
        for (int i = 0; i <= stones.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= stones.length; i++) {

            for (int j = 1; j <= target; j++) {

                // Don't pick
                dp[i][j] = dp[i - 1][j];

                // Pick
                if (j >= stones[i - 1]) {
                    dp[i][j] = dp[i][j] ||
                               dp[i - 1][j - stones[i - 1]];
                }
            }
        }

        // Find the closest achievable sum to target
        for (int j = target; j >= 0; j--) {

            if (dp[stones.length][j]) {
                return totalSum - 2 * j;
            }
        }

        return 0;
    }
}