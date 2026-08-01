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
    public void flatten(TreeNode root) {
        Queue<TreeNode>que=new LinkedList<>();
        if(root==null)return;
        insert(root,que);
        TreeNode curr=que.poll();
        while(!que.isEmpty()){
            TreeNode next=que.poll();
            curr.left=null;
            curr.right=next;
            curr=next;

        }
    }
    static void insert(TreeNode root,Queue<TreeNode>que){
        if(root==null){
            return;
        }
        que.offer(root);
        insert(root.left,que);
        insert(root.right,que);
    }
}