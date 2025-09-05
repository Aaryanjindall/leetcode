class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode newroot = new TreeNode(val);
            newroot.left = root;
            return newroot;
        }
        int currdepth = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode curr = q.poll();
                if(currdepth == depth - 1){
                

                TreeNode left = curr.left;
                TreeNode right = curr.right;

                TreeNode newleft = new TreeNode(val);
                TreeNode newright = new TreeNode(val);

                curr.left = newleft;
                curr.right = newright;

                newleft.left = left;
                newright.right = right;

                

                }
                else{
                    
                    if(curr.left != null){
                        q.add(curr.left);
                    } 
                    if(curr.right != null){
                        q.add(curr.right);
                    }
                   
                }


            }
            currdepth++;
            
            
        }

        return root;
    }
}