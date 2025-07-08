class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean vis [] = new boolean[rooms.size()];
        dfs(rooms , 0 , rooms.size()-1 , vis);
        for(int i = 0 ; i < vis.length ; i++){
            if(vis[i] == false){
                return false;
            }

        }
        return true;
    }
    private void dfs(List<List<Integer>> rooms ,int  curr , int dest , boolean [] vis){
        vis[curr] = true;
        for(int neigh : rooms.get(curr)){
            if(!vis[neigh]){
                dfs(rooms , neigh , rooms.size()-1 , vis);
            }
           
        }
        
        
    }
}