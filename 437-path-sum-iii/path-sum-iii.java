class Solution {
    int tcount = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        int left = pathSum(root.left , targetSum);
        int right = pathSum(root.right,targetSum);

        count(root,(long)targetSum);
        return tcount;


    }
    private void count(TreeNode root , long target){
        if(root == null)return ;
        
        if(target == root.val){
            tcount++;
        }

        count(root.left,target-root.val);
        count(root.right,target-root.val); 

        



    }
}