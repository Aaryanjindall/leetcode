class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)return null;
     if(key > root.val){
            root.right = deleteNode(root.right,key);
        }
        else if(key < root.val){
            root.left = deleteNode(root.left,key);
        }
        else{
            //agr leaf h 
            if(root.left == null && root.right == null){
                return null;
            }
            //agr ek bacha h
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }
            //agr do bache h 
            TreeNode succ = inordersucc(root.right);
            root.val = succ.val;
            root.right = deleteNode(root.right,succ.val);
            
        }
return root;

    }
    private TreeNode inordersucc(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
}
