class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for (String str : wordDict) {
            set.add(str);
        }

        Boolean[] dp = new Boolean[s.length()];

        return solve(0, set, s, dp);
    }

    boolean solve(int idx, HashSet<String> set, String s, Boolean[] dp) {
        if (idx == s.length()) {
            return true;
        }

        if (dp[idx] != null) {
            return dp[idx];
        }

        for (int i = idx; i < s.length(); i++) {
            String tempword = s.substring(idx, i + 1);

            if (set.contains(tempword)) {
                if (solve(i + 1, set, s, dp)) {
                    return dp[idx] = true;
                }
            }
        }

        return dp[idx] = false;
    }
}