class Solution {
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);

        coun(root,(long)targetSum);
        return count;
    }
    private void coun(TreeNode root , long tar){
        if(root == null){
            return;
        }
        if(tar == root.val){
            count++;
        }
        coun(root.left,tar-root.val);
        coun(root.right,tar-root.val);
    }
}