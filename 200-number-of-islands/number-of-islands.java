class Solution {
    public int numIslands(char[][] grid){
        int islands = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean [n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if( grid[i][j] == '1'&& !vis[i][j]){
                    dfs(vis,grid,i,j,n,m);
                    islands++;
                }
            }
        }
        return islands;
    }
    private void dfs(boolean vis[][] , char grid[][] , int i , int j , int n , int m)
    {
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0'){
            return;
        }
        if(vis[i][j])return;
        vis[i][j] = true;


        dfs(vis,grid,i+1,j,n,m);
        dfs(vis,grid,i,j-1,n,m);
        dfs(vis,grid,i-1,j,n,m);
        dfs(vis,grid,i,j+1,n,m);
        



    }
}