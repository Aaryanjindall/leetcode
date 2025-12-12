class Solution {
    int result = -1;
    public int longestCycle(int[] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < edges.length ; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0 ; i < edges.length ; i++){
            int u = i;
            int v = edges[i];
            if(v < 0){
                continue;
            }
            graph.get(u).add(v);
        }
        int n = edges.length;
        boolean vis[] = new boolean[n];
        boolean inrec[] = new boolean[n];
        int count [] = new int[n];
        Arrays.fill(count,1);
        for(int i = 0 ; i < n ; i++){
            if(!vis[i]){
                solve(graph,vis,inrec,count,i);
            }
        }
        return result;

        
    }
    private void solve(List<List<Integer>> graph,boolean vis[] , boolean [] inrec , int count[] , int i){
        vis[i] = true;
        inrec[i] = true;
        
        for(int neigh : graph.get(i)){
            if(!vis[neigh]){
                count[neigh] = count[i]+1;
                solve(graph,vis,inrec,count,neigh);
            }
            else if(inrec[neigh]){
                //cycle mil gyi
                result = Math.max(result,count[i]-count[neigh]+1);
            }

        }
        inrec[i] = false;

    }
}