class Solution {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return ans;
    }
    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = Math.max(helper(root.left),0);
        int r = Math.max(helper(root.right),0);
        int temp1 = Math.max(l,r)+root.val;
        int temp2 = l+r+root.val;
        ans = Math.max(ans,temp2);
        return temp1;
    }
}