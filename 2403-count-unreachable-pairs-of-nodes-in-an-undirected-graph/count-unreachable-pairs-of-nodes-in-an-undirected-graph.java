class Solution {
    public long countPairs(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>());
        }
        for(int [] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean vis[] = new boolean[n];
        ArrayList<Integer> nodessizes = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(!vis[i]){
                int nodes = dfs(vis,i,graph);
                nodessizes.add(nodes);
            }
        }
        long totalcount = 0;
        long sum = 0;
        for(int size : nodessizes){
            
            totalcount += size*((n-sum)-size);
            sum += size;
        }
        return totalcount;


    }
    private int dfs(boolean vis[] , int curr , ArrayList<ArrayList<Integer>> graph){
        vis[curr] = true;
        int count = 1;

        for(int neigh : graph.get(curr)){
            if(!vis[neigh]){
                count += dfs(vis,neigh,graph);
            }
        }

        return count;
    }
}