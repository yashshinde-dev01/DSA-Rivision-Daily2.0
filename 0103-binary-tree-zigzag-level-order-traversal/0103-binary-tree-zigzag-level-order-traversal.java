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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
        Queue<TreeNode>q=new LinkedList<>();
        if(root==null)return ans;
        q.add(root);
        int cnt=1;
        while(!q.isEmpty()){
           int level=q.size();
           ArrayList<Integer>lst=new ArrayList<>();
           for(int i=0;i<level;i++){
            if(q.peek().left!=null)q.offer(q.peek().left);
            if(q.peek().right!=null)q.offer(q.peek().right);
            lst.add(q.poll().val);
           }
           if(cnt%2==0){
            Collections.reverse(lst);
           }
           cnt++;
           ans.add(lst);  
        }
        return ans;
    }
}