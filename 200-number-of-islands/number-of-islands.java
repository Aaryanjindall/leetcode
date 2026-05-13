class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    dfs(grid,i,j,n,m,vis);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(char [][]grid,int i , int j , int n , int m,boolean vis[][]){
        if(i<0 || j < 0 || i >= n || j >= m || grid[i][j] == '0' || vis[i][j] == true){
            return;
        }
        vis[i][j] = true;
        dfs(grid,i+1,j,n,m,vis);
        dfs(grid,i,j+1,n,m,vis);
        dfs(grid,i-1,j,n,m,vis);
        dfs(grid,i,j-1,n,m,vis);
    }
}