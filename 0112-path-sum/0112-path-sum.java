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
    int cal=0;
    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(root,0,sum);
    }
    private boolean helper(TreeNode root,int cal,int sum){
        if(root==null)return false;
        cal+=root.val;
        if(cal==sum && root.left==null && root.right==null){
            return true;
        }
        boolean left=helper(root.left,cal,sum);
        boolean right=helper(root.right,cal,sum);
        return left || right;
    }
}