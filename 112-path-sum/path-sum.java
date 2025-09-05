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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root,0,targetSum);
        
    }

    private boolean dfs (TreeNode root ,int currsum, int target){
        if(root == null){
            return false;
        }

        currsum += root.val;

        if(root.left == null && root.right == null){
            if(currsum == target){
                return true;
            }
        }

        return dfs(root.left , currsum , target) || dfs(root.right , currsum , target);


    }
}