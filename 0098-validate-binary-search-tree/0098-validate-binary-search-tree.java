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
    public boolean isValidBST(TreeNode root) {
        Integer min=null;
        Integer max=null;
       return isBST(root,min,max); 
    }
static boolean isBST(TreeNode root,Integer min,Integer max){
    if(root==null)return true;
    if(min!=null && root.val<=min)return false;
    if(max!=null && root.val>=max)return false;

    boolean  left=isBST(root.left,min,root.val);
    boolean right=isBST(root.right,root.val,max);
    return left && right;
    }
}