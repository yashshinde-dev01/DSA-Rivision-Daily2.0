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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
      if(root==null){
        return false;
      }

      if(root.val == subRoot.val && isequal(root,subRoot)){
        return true;
      }
      boolean left=isSubtree(root.left,subRoot);
      boolean right=isSubtree(root.right,subRoot);
      return left || right;  
    }
    private  static boolean isequal(TreeNode root,TreeNode subroot){
        if(root==null && subroot==null )return true;
        if(root==null || subroot==null)return false;
        if(root.val!=subroot.val)return false;
        return isequal(root.left,subroot.left) && isequal(root.right,subroot.right);
    }
}