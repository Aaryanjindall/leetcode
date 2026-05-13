class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        //directed cycle q 
        //agr cycle bngyi toh false else true
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            list.add(new ArrayList<>());
        }
        for(int pre[] : prerequisites){
            int u = pre[0];
            int v = pre[1];
            list.get(v).add(u);
        }
        boolean vis[] = new boolean[n];
        boolean rec[] = new boolean[n];
        for(int i = 0 ; i < n ; i++){
            if(!vis[i]){
                if(check(n,list,i,vis,rec)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean check(int n , List<List<Integer>> list , int curr , boolean vis[] , boolean rec[]){
        vis[curr] = true;
        rec[curr] = true;
        for(int neigh : list.get(curr)){
            if(!vis[neigh]){
                if(check(n,list,neigh,vis,rec)){
                    return true;
                }
            }
            else if(rec[neigh] == true){
                return true;
            }
        }
        rec[curr] = false;
        return false;
    }
}