class Solution {
    public int maxLevelSum(TreeNode root) {
        if(root == null)return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int maxsum=Integer.MIN_VALUE;
        int level = 1;
        int maxlevel = 1;
        while(!q.isEmpty()){
            int size = q.size();
             int sum = 0;
            for(int i = 0 ; i < size ; i++){
                TreeNode curr = q.poll();
                int value = curr.val;
                sum += value;

                if(curr.left != null)q.add(curr.left);
                if(curr.right != null)q.add(curr.right);
                
                

            }
            
            if(sum > maxsum){
                maxsum = sum;
                maxlevel = level;
            }
            level++;




            


        }

        return maxlevel;
    }
}