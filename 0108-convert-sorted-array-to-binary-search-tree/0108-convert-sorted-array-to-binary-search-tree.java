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
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums,0,nums.length-1);
    }
    static TreeNode build(int[]arr,int left,int right){
        if(left>right){
            return null;
        }

        int mid=left+(right-left)/2;
        TreeNode root=new TreeNode(arr[mid]);
        root.left=build(arr,left,mid-1);
        root.right=build(arr,mid+1,right);

        return root;
    }
}