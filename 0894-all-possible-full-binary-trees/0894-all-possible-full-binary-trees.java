class Solution {
    Map<Integer, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return new ArrayList<>();
        }

        if (n == 1) {
            List<TreeNode> base = new ArrayList<>();
            base.add(new TreeNode(0));
            return base;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        List<TreeNode> ans = new ArrayList<>();

        for (int left = 1; left < n; left += 2) {
            int right = n - 1 - left;

            List<TreeNode> leftTrees = allPossibleFBT(left);
            List<TreeNode> rightTrees = allPossibleFBT(right);

            for (TreeNode l : leftTrees) {
                for (TreeNode r : rightTrees) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;

                    ans.add(root);
                }
            }
        }

        memo.put(n, ans);
        return ans;
    }
}