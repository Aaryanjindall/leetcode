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
    public TreeNode buildTree(int[] pre, int[] in) {
        TreeNode root = construct(pre,0,pre.length-1 , in , 0, in.length-1);
        return root;
    }
    private TreeNode construct(int []pre , int prest , int preend , int ino[] , int inst , int inend){
        if(prest > preend || inst > inend){
            return null;
        }
        TreeNode root = new TreeNode(pre[prest]);
        int idx = -1;
        for(int i = inst ; i <= inend ; i++){
            if(root.val == ino[i]){
                idx = i;
            }
        }
        int leftsize = idx-inst;
        root.left = construct(pre,prest+1,prest+leftsize,ino,inst,idx-1);
        root.right = construct(pre,prest+leftsize+1,preend,ino,idx+1,inend);
        return root;
    }
}