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
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return issame(root.left,root.right);
    }
    private boolean issame(TreeNode leftt , TreeNode rightt){
        if(leftt == null && rightt == null){
            return true;
        }
        if(leftt == null || rightt == null){
            return false;
        }
        if(leftt.val != rightt.val){
            return false;
        }
        return issame(leftt.left,rightt.right) && issame(leftt.right,rightt.left);
    }

}