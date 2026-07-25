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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>lst=new ArrayList<>();
        Queue<TreeNode>que=new LinkedList<>();
        if (root == null) return lst;
        que.offer(root);
        while(!que.isEmpty()){
            int level=que.size();
            for(int i=0;i<level;i++){
                TreeNode curr=que.poll();
                if(curr.left!=null)que.offer(curr.left);
                if(curr.right!=null)que.offer(curr.right);
                if(i==level-1){
                    lst.add(curr.val);
                }
            }
        }
        return lst;
    }
}