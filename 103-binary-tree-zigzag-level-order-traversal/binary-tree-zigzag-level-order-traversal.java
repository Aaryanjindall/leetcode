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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode>q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while(!q.isEmpty()){
            List<Integer>lister = new ArrayList<>();
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode curr = q.poll();
                int ele = curr.val;
                lister.add(ele);
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }

            }
            if(level%2 == 1){
                Collections.reverse(lister);
            }
            level++;
            
            list.add(lister);
            
        }

        return list;
    }
}