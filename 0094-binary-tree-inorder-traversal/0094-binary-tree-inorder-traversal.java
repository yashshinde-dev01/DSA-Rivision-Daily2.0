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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode>st=new Stack<TreeNode>();
        List<Integer>lst=new ArrayList<>();
        if(root==null){
            return lst;
        }
        while(true){
            if(root!=null){
                st.push(root);
                root=root.left;
            }else{
                if(st.isEmpty())break;
                root=st.pop();
                lst.add(root.val);
                root=root.right;
            }
        }
        return lst;
    }
}