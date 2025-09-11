class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;  // agar -1 aaya toh unbalanced
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;  // null ki height 0

        int left = dfs(node.left);
        if (left == -1) return -1;   // agar left unbalanced h

        int right = dfs(node.right);
        if (right == -1) return -1;  // agar right unbalanced h

        if (Math.abs(left - right) > 1) return -1; // diff > 1 => unbalanced

        return Math.max(left, right) + 1; // height return karo
    }
}
