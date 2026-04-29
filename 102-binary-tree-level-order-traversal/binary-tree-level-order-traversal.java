class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> lister = new ArrayList<>();
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode curr = q.poll();
                int value = curr.val;
                lister.add(value);
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            list.add(lister);
        }
        return list;
    }
}