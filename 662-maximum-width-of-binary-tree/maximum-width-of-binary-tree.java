class Solution {
    class Pair{
        TreeNode root;
        int idx;
        Pair(TreeNode root, int idx){
            this.root = root;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        Deque<Pair> dq = new ArrayDeque<>();
        dq.add(new Pair(root,0));
        int maxwidth = 1;

        while(!dq.isEmpty()){
            int size = dq.size();
            int minidx = dq.peekFirst().idx;
            int maxidx = dq.peekLast().idx;
            for(int i = 0 ; i < size ; i++){
                
                Pair p = dq.poll();
                TreeNode curr = p.root;
                int idx = p.idx;

                if(curr.left != null ){
                    dq.add(new Pair(curr.left , 2*idx + 1));
                }
                if(curr.right != null){
                    dq.add(new Pair(curr.right , 2*idx +2));
                }

                

                

                

            }
            maxwidth = Math.max(maxwidth,maxidx-minidx+1);
        }

        return maxwidth;
    }
}