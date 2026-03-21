class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftt = maxDepth(root.left);
        int rightt = maxDepth(root.right);
        return 1+Math.max(leftt,rightt);
    }
}