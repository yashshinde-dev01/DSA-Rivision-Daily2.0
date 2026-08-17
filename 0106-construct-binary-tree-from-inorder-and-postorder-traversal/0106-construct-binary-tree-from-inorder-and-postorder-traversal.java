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
    int poidx;
    HashMap<Integer,Integer>map=new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        poidx=postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(postorder,0,inorder.length-1);
    }
    private TreeNode helper(int[]postorder,int start,int end){
        if(start>end)return null;

        int node=postorder[poidx--];
        TreeNode root=new TreeNode(node);
        int inidx=map.get(node);


         root.right=helper(postorder,inidx+1,end);
        root.left=helper(postorder,start,inidx-1);

        return root;
    }
}