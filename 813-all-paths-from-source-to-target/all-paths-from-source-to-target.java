class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(0,graph,new ArrayList<>(),list);
        return list;
    }
    private void dfs(int curr , int [][] graph, List<Integer> lister , List<List<Integer>> list){
        lister.add(curr);
        if(curr == graph.length-1){
            list.add(new ArrayList<>(lister));
        }
        for(int neigh : graph[curr]){
            dfs(neigh,graph,lister,list);
            lister.remove(lister.size()-1);
        }
        
    }
}