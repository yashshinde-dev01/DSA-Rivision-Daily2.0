class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        return solve(s, 0, dp);
    }

    int solve(String s, int i, int[] dp) {

        if (i == s.length()) {
            return 1;
        }

        if (s.charAt(i) == '0') {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        // Take one digit
        int one = solve(s, i + 1, dp);

        // Take two digits
        int two = 0;

        if (i + 1 < s.length()) {
            int num = Integer.parseInt(s.substring(i, i + 2));

            if (num >= 10 && num <= 26) {
                two = solve(s, i + 2, dp);
            }
        }

        return dp[i] = one + two;
    }
}