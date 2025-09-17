class Solution {
    public class Pair{
        TreeNode node;
        TreeNode parent;
        Pair(TreeNode node , TreeNode parent){
            this.node = node;
            this.parent = parent;
        }
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if(root == null)return false;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,null));
        int depth = 0;
        int currdepthx = 0;
        int currdepthy = 0;
        while(!q.isEmpty()){
            int size = q.size();
            TreeNode xparent = null;
            TreeNode yparent = null;
            
            
            for(int i = 0 ; i < size ; i++){
                Pair p = q.poll();
                TreeNode child = p.node;
                TreeNode parent = p.parent;

                if(child.val == x){
                    xparent = parent;
                    currdepthx = depth;
                }
                if(child.val == y){
                    yparent = parent;
                    currdepthy = depth;
                }

                if(child.left != null)q.add(new Pair(child.left,child));
                if(child.right!= null)q.add(new Pair(child.right,child));


            }
            depth ++;
            if (xparent != null && yparent != null){
                if(xparent != yparent){
                if(currdepthx != currdepthy)return false;
                else {
                    return true;
                }
            }
            }
            
            
        }
        return false;
    }
}