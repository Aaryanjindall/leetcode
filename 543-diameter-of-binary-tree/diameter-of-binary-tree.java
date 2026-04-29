class Solution {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }
    private int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = height(root.left);
        int r = height(root.right);
        diameter = Math.max(diameter,(l+r));
        return Math.max(l,r)+1;
    }
}