class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder){
        return solve(preorder , 0 , preorder.length -1 ,inorder ,  0 , inorder.length - 1);
    }
    private TreeNode solve(int [] preorder , int prestart , int prend , int [] inorder , int instart , int inend){
        if(instart > inend || prestart > prend){
            return null;
        }
        int rootval = preorder[prestart];

        TreeNode root = new TreeNode(rootval);
        int rootidx = -1;
        for(int i = instart ; i <= inend ; i++){
            if(inorder[i] == rootval){
                rootidx = i;
                break;
            }
        }

        int leftsize = rootidx - instart;
        

        root.left = solve(preorder , prestart +1 , prestart+leftsize ,inorder, instart,rootidx -1);
        root.right = solve(preorder , prestart + leftsize + 1  , prend , inorder , rootidx +1 , inend );

        return root;

        
    }
}