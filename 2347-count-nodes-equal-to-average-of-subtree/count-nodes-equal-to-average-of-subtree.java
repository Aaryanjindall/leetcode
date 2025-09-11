class Solution {
    int ans = 0;

    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return ans;
    }

    private int solve(TreeNode root) {
        if (root == null) return 0;

        int leftSum = solve(root.left);
        int rightSum = solve(root.right);

        int sum = leftSum + rightSum + root.val;
        int count = getCount(root); // har call pe subtree ka count nikala

        if (sum / count == root.val) {
            ans++;
        }

        return sum;
    }

    private int getCount(TreeNode root) {
        if (root == null) return 0;
        return 1 + getCount(root.left) + getCount(root.right);
    }
}
