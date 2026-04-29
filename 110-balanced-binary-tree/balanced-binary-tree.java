class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return valid(root) != -1;
    }
    private int valid(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = valid(root.left);
        if(l == -1) return -1;
        int r = valid(root.right);
        if(r == -1) return -1;
        int height = Math.max(l,r)+1;
        if(Math.abs(l-r) > 1){
            return -1;
        }
        return height;
    }

}