class Solution {
    public TreeNode deleteNode(TreeNode root, int key) { 
        if(root == null){
            return null;
        }
        if(key < root.val){
            root.left = deleteNode(root.left,key);
            return root;
        }
        else if(key > root.val){
            root.right = deleteNode(root.right,key);
            return root;
        }
        else{
            //one leaf
            if(root.left == null && root.right == null){
                return null;
            }
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }
            else{
                TreeNode succ = inorder(root.right);
                root.val = succ.val;
                root.right = deleteNode(root.right,succ.val);
                return root;
            }
        }
    }
    private TreeNode inorder(TreeNode node){
        TreeNode curr = node;
        while(curr.left != null){
            curr = curr.left;
        }
        return curr;
    }
}