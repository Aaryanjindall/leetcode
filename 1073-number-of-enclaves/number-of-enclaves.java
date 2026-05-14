class Solution {
    public int numEnclaves(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int count = 0;
        boolean vis[][] = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            if(board[i][0] == 1)dfs(vis,i,0,board);
            if(board[i][m-1] == 1)dfs(vis,i,m-1,board);
        }
        for(int j = 0 ; j < m ; j++){
            if(board[0][j] == 1)dfs(vis,0,j,board);
            if(board[n-1][j] == 1)dfs(vis,n-1,j,board);
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(board[i][j] == 1 && !vis[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(boolean vis[][] , int i , int j , int[][] board){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length ){
            return;
        }
        if(board[i][j] == 0){
            return;
        }
        if(vis[i][j] == true){
            return;
        }
        vis[i][j] = true;
        dfs(vis,i+1,j,board);
        dfs(vis,i-1,j,board);
        dfs(vis,i,j+1,board);
        dfs(vis,i,j-1,board);
    }
    
}