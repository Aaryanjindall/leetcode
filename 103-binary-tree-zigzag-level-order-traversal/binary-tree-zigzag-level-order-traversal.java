class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)return list;
        q.add(root);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> lister = new ArrayList<>();
            for(int i = 0 ; i < size ; i++){
                TreeNode curr = q.poll();
                lister.add(curr.val);
                if(curr.left != null)q.add(curr.left);
                if(curr.right != null)q.add(curr.right);
            }
            if(level%2 == 1){
                int l = 0;
                int r = lister.size()-1;
                while(l < r){
                    int temp = lister.get(l);
                    lister.set(l,lister.get(r));
                    lister.set(r,temp);
                    l++;
                    r--;
                }
            }
            level++;
            list.add(lister);
        }
        return list;
    }
}