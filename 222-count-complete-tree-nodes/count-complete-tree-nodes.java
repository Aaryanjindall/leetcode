class Solution {
    public int countNodes(TreeNode root) {
        int count = 0;
        if(root == null){
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);

        count = left + right + 1;
        return count;

    }
}