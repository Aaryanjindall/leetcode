class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean [n][m];
        int island = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    dfs(vis,grid,i,j);
                    island++;
                }
            }
        }
        return island;
    }
    private void dfs(boolean vis[][] , char [][] grid , int i , int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }
        if(vis[i][j]){
            return;
        }
        vis[i][j] = true;
        dfs(vis,grid,i+1,j);
        dfs(vis,grid,i,j+1);
        dfs(vis,grid,i,j-1);
        dfs(vis,grid,i-1,j);
    }
}