class Solution {
    public int sumNumbers(TreeNode root) {

        return dfs(root,0);
    }
    private int dfs(TreeNode root , int sum){
        if(root == null)return 0;
        sum = sum*10+root.val;
        if(root.left == null && root.right == null){
            return sum;
        }
        int left = dfs(root.left,sum);
        int right = dfs(root.right,sum);
        
        return left+right;
    }

}