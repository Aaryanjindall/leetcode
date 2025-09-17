class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return solve(preorder, 0, preorder.length - 1,
                     postorder, 0, postorder.length - 1);
    }

    private TreeNode solve(int[] preorder, int preStart, int preEnd,
                           int[] postorder, int postStart, int postEnd) {

        if (preStart > preEnd || postStart > postEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

     
        if (preStart == preEnd) return root;


        int leftRootVal = preorder[preStart + 1];
        int idx = postStart;
        while (postorder[idx] != leftRootVal) {
            idx++;
        }

        int leftSize = idx - postStart + 1;

        root.left = solve(preorder, preStart + 1, preStart + leftSize,
                          postorder, postStart, idx);

        root.right = solve(preorder, preStart + leftSize + 1, preEnd,
                           postorder, idx + 1, postEnd - 1);

        return root;
    }
}
