class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>());
        }
        for(int edge[] : edges){
            graph.get(edge[1]).add(edge[0]);
            graph.get(edge[0]).add(edge[1]);
        }
        return dfs(graph , 0 ,  -1 , hasApple);
    }
    private int dfs(ArrayList<ArrayList<Integer>> graph , int child , int par , List<Boolean> hasApple){
        int time = 0;
        for(int neigh : graph.get(child)){
            if(neigh == par )continue;
            int childtime = dfs(graph,neigh,child,hasApple);
            if(childtime > 0 || hasApple.get(neigh)){
                time += childtime + 2;
            }
        }

        return time;

    }
}