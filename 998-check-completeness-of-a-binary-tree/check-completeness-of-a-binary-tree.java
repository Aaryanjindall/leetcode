/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if(root == null)return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean isnull = false;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode curr = q.poll();
                if(curr.left != null){
                    if(isnull)return false;//pehla null aagya toh false aayga
                    q.add(curr.left);

                }
                else{
                    isnull = true;
                }
                if(curr.right != null){
                    if(isnull)return false;
                    q.add(curr.right);
                }
                else{
                    isnull = true;
                }


            }
        }

        return true;

        

    }
}