class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean vis[] = new boolean[n];
        dfs(0,vis,rooms);

        for(int i = 0 ; i < n ; i++){
            if(vis[i] == false){
                return false;
            }
        }
        return true;
    }
    private void dfs(int curr, boolean [] vis , List<List<Integer>>rooms){
        vis[curr] = true;
        for(int neigh : rooms.get(curr)){
            if(!vis[neigh]){
                dfs(neigh,vis,rooms);
            }
        }
    }
}