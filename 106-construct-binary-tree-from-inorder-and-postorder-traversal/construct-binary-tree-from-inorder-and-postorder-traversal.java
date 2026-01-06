class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return solve(inorder , 0 , inorder.length -1 ,postorder ,  0 , postorder.length - 1);
    }

    private TreeNode solve(int [] inorder , int instart , int inend , int [] postorder , int postart , int postend){
        if(instart > inend || postart > postend){
            return null;
        }
        int rootval = postorder[postend];

        TreeNode root = new TreeNode(rootval);
        int rootidx = -1;
        for(int i = instart ; i <= inend ; i++){
            if(inorder[i] == rootval){
                rootidx = i;
                break;
            }
        }

        int leftsize = rootidx - instart;

        root.left = solve(inorder , instart , rootidx -1 ,postorder, postart , postart+leftsize-1);
        root.right = solve(inorder , rootidx +1 , inend , postorder , postart + leftsize , postend -1 );

        return root;

        
    }
}