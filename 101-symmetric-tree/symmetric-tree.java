class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return helper(root.left , root.right);
        

        
    }
    private boolean helper(TreeNode leftt , TreeNode rightt){
        if(leftt == null && rightt == null)return true;
        if(leftt == null || rightt == null)return false;
        if((leftt.val != rightt.val)){
            return false;
        }
        return helper(leftt.left , rightt.right) && helper(leftt.right , rightt.left);
        
    }
}