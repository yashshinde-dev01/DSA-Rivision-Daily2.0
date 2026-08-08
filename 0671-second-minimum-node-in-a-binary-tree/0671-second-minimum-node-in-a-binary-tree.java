/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        long[] ans = {Long.MAX_VALUE};
        
        dfs(root, root.val, ans);
        
        return ans[0] == Long.MAX_VALUE ? -1 : (int) ans[0]; 
    }
       private void dfs(TreeNode root, int min, long[] ans) {
        if (root == null) {
            return;
        }

        if (root.val > min && root.val < ans[0]) {
            ans[0] = root.val;
        }

        dfs(root.left, min, ans);
        dfs(root.right, min, ans);
    }
}