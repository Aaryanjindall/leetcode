class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int [][] vis = new int[rows][cols];
        for(int j = 0 ; j < cols ; j++){//columns mai check hora h 
            if(board[0][j] == 'O')dfs(board,vis,rows,cols,0,j);
            if(board[rows-1][j] == 'O')dfs(board,vis,rows,cols,rows-1,j);
        }
        for(int i = 0 ; i < rows ; i++){
            if(board[i][0] == 'O')dfs(board,vis,rows,cols,i,0);
            if(board[i][cols-1] == 'O')dfs(board,vis,rows,cols,i,cols-1);
        }

        for(int i=0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(board[i][j] == 'O' && vis[i][j] != 1){
                    board[i][j] = 'X';
                    System.out.println(board[i][j]);
                }
                
            }
        }
    }
    private void dfs(char [][] board, int [][] vis , int r , int c , int i , int j){
        if(i < 0 || i >= r || j < 0 || j >= c || board[i][j] != 'O' || vis[i][j] == 1)return;
        vis[i][j] = 1;
        dfs(board,vis,r,c,i-1,j);
        dfs(board,vis,r,c,i+1,j);
        dfs(board,vis,r,c,i,j+1);
        dfs(board,vis,r,c,i,j-1);
    }
}