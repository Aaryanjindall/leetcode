class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot){
        if(root == null){
            return false;
        }
        if(issame(root, subRoot)) return true;
        
        boolean left = isSubtree(root.left , subRoot);
        boolean right = isSubtree(root.right , subRoot);

        return left || right;
    }
    private boolean issame(TreeNode r , TreeNode t){
        if(r == null && t == null) return true;
        if(r == null || t == null) return false;

        if(r.val != t.val){
            return false;
        }
        return issame(r.left , t.left) && issame(r.right , t.right);
    }
}