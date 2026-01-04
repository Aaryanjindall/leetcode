class Solution {
    public boolean isBalanced(TreeNode root) {
        return bal(root) != -1;
    }
    private int bal(TreeNode node){
        if(node == null)return 0;
          
        int left = bal(node.left);
        if(left == -1)return -1;
        int right = bal(node.right);
        if(right == -1)return -1;
        if(Math.abs(left-right)>1){
            return -1;
        }
        return Math.max(left,right)+1;

    }

}