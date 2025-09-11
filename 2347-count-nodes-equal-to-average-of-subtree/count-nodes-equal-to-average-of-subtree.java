class Solution {
    int count = 0;
    public int averageOfSubtree(TreeNode root){
        if (root == null) return 0;
        helper(root);
        return count;
    }
    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int leftsum = helper(root.left);
        int rightsum = helper(root.right);
        int countnode = getcount(root);
        int sum = (leftsum + rightsum + root.val);
        int av = sum/countnode;
        if(av == root.val){
            count++;
        }

        return sum;
    }

    private int getcount(TreeNode node){
        if(node == null)return 0;

        int leftc = getcount(node.left);
        int rightc = getcount(node.right);

        return leftc + rightc + 1;
    }
}