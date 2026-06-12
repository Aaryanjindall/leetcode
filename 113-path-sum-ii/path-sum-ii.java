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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        bt(list,root,targetSum,new ArrayList<>());
        return list;
    }
    private void bt(List<List<Integer>> list , TreeNode root , int tar , List<Integer> lister){
        if(root == null){
            return;
        }
        lister.add(root.val);
        if(root.left == null && root.right == null){
            if(tar == root.val){
                list.add(new ArrayList<>(lister));
            }
        }
        bt(list,root.left,tar-root.val,lister);
        bt(list,root.right,tar-root.val,lister);
        lister.remove(lister.size()-1);
    }
}