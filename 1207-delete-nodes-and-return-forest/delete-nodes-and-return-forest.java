class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> list = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        for(int val : to_delete){
            hs.add(val);
        }

        root =  dfs(root,hs,list);
        if(root != null)list.add(root);

        return list;
            
    }
    private TreeNode dfs(TreeNode root , HashSet<Integer> hs , List<TreeNode> list){
        if(root == null){
            return null;
        }

        root.left = dfs(root.left , hs , list);
        root.right = dfs(root.right , hs , list);

        if(hs.contains(root.val)){
            if(root.left != null)list.add(root.left);
            if(root.right != null)list.add(root.right);
            return null;
        }

        return root;


    }
}