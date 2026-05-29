class Solution {
    class Pair{
        TreeNode root;
        int idx = 0;
        Pair(TreeNode root,int idx){
            this.root = root;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        Deque<Pair> q = new ArrayDeque<>();
        int width = 1;
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            int minidx = q.peekFirst().idx;
            int maxidx = q.peekLast().idx;
            width = Math.max(maxidx-minidx+1,width);
            for(int i = 0 ; i < size ; i++){
                Pair p = q.poll();
                TreeNode curr = p.root;
                int index = p.idx;
                if(curr.left != null){
                    q.add(new Pair(curr.left,2*index+1));
                }
                if(curr.right != null){
                    q.add(new Pair(curr.right,2*index+2));
                }
            }


        }
        return width;
    }
}