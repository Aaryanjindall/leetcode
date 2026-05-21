class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        return root;
    }
}