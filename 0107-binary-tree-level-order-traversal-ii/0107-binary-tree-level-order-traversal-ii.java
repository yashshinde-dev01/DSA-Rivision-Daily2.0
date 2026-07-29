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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode>que=new LinkedList<TreeNode>();
        List<List<Integer>>ans=new ArrayList<>();
        que.offer(root);
        if(root==null)return ans;
        while(!que.isEmpty()){
            int level=que.size();
            List<Integer>lst=new ArrayList<>();
            for(int i=0;i<level;i++){
                if(que.peek().left!=null)que.offer(que.peek().left);
                if(que.peek().right!=null)que.offer(que.peek().right);
                lst.add(que.poll().val);
            }
            ans.add(lst);
        }
       Collections.reverse(ans);
       return ans ;
       
    }
}