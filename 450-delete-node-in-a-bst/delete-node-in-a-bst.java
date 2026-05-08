class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(root.val < key){
            root.right = deleteNode(root.right,key);
            return root;
        }
        else if(root.val > key){
            root.left = deleteNode(root.left,key);
            return root;
        }
        else{
            //leaf
            if(root.left == null && root.right == null){
                return null;
            }
            else if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            else{
                TreeNode succ = inordersucc(root.right);
                root.val = succ.val;
                root.right = deleteNode(root.right,succ.val);
                return root;
            }
        }
    }
    private TreeNode inordersucc(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
}