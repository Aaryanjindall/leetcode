class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = construct(inorder,0,inorder.length-1 , postorder, 0, postorder.length-1);
        return root;
    }
    private TreeNode construct(int [] inorder , int inst , int inend , int [] postorder , int post , int postend){
        if(inst > inend || post > postend){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postend]);
        int idx = -1;
        for(int i = inst ; i <= inend ; i++){
            if(inorder[i] == root.val){
                idx = i;
            }
        }
        int leftsize = idx-inst;
        root.left = construct(inorder,inst,idx-1,postorder,post,post+leftsize-1);
        root.right = construct(inorder,idx+1,inend,postorder,post+leftsize,postend-1);
        return root;
    }
}