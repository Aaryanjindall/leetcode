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
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return ans;
    }
    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = Math.max(0, helper(root.left));
        int r = Math.max(0, helper(root.right));
        int temp = Math.max(l,r)+root.val;
        int temp2 = l+r+root.val;
        ans = Math.max(temp2,ans);
        return temp;
    }
}