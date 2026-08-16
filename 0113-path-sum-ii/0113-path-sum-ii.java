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
     List<List<Integer>>ans=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<Integer>lst=new ArrayList<>();
        helper(root,targetSum,0,lst);
        return ans;
    }
    private void helper(TreeNode root,int targetsum,int sum,ArrayList<Integer>lst){
        if(root==null)return;
        sum+=root.val;
        lst.add(root.val);
        if(sum==targetsum && root.left==null && root.right==null){
            ans.add(new ArrayList<>(lst));
        }
        helper(root.left,targetsum,sum,lst);
        helper(root.right,targetsum,sum,lst);
        lst.remove(lst.size()-1);
    }
}