class Solution {
    public int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        int n = isConnected[0].length;
        boolean vis [] = new boolean[n];
        for(int i = 0 ; i < n ; i++){
            if(!vis[i]){
                dfss(isConnected,vis,i);
                provinces++;
            }
        }
        return provinces;
    }
    private void dfss(int [][] isConnected , boolean [] vis , int i){
        vis[i] = true;
        for(int j = 0 ; j < isConnected.length  ; j++){
            if(isConnected[i][j] == 1 && !vis[j]){
                dfss(isConnected,vis,j);
            }
        }
    }
}