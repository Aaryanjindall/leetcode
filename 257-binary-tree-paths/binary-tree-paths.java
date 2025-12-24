class Solution {
    StringBuilder sb = new StringBuilder();
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        dfs(root,list);
        return list;

    }
    private void dfs(TreeNode node , List<String> list){
        int len = sb.length();
        sb.append(node.val);
        if(node.left == null && node.right == null){
            list.add(sb.toString());
            sb.setLength(len);
            return;
        }
        
        sb.append("->");

        if(node.left != null)dfs(node.left,list);
        if(node.right != null)dfs(node.right,list);

        sb.setLength(len);
        
        // dfs(node.left);
        // dfs(node.right);

        

        
    }
}