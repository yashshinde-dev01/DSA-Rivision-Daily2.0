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
    int preidx=0;
    HashMap<Integer,Integer>map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(preorder,0,inorder.length-1);
    }
    private TreeNode helper(int[]preorder,int start,int end){
        if(start>end){
            return null;
        }
        int node=preorder[preidx++];
        TreeNode root=new TreeNode(node);

        int inidx=map.get(node);

        root.left=helper(preorder,start,inidx-1);
        root.right=helper(preorder,inidx+1,end);

        return root;
    }
}