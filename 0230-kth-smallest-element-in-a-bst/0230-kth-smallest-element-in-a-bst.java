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
    int cnt=0;
    public int kthSmallest(TreeNode root, int k) {
        return helper(root,k).val;
    }
    private TreeNode helper(TreeNode root,int k){
        if(root==null)return null;
       TreeNode left=helper(root.left,k);
       if(left!=null)return left;
       cnt++;
       if(cnt==k){
        return root;
       }
       return helper(root.right,k);
    }
}