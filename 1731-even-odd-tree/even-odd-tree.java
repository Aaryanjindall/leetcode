class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        int depth = 0;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0 ; i < size ; i++){
                TreeNode curr = q.poll();
                int val = curr.val;
                list.add(val);
                if(curr.left != null)q.add(curr.left);
                if(curr.right != null)q.add(curr.right);  
            }

            for(int i = 0 ; i < list.size() ; i++){
                if(depth % 2 == 0){
                    if((list.get(i) % 2 == 0) ||((i>0) && (list.get(i)<=list.get(i-1)))){
                        return false;
                    }
                }
                else{
                    if((list.get(i) % 2 == 1) || ((i>0) && (list.get(i)>=list.get(i-1)))){
                        return false;
                    }
                }
            }
            depth++;
            

            

                
                
                
        
            
                

            
        }
        return true;
    }
}