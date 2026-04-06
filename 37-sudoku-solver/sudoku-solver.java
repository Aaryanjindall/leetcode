class Solution {
    public void solveSudoku(char[][] board) {
        solve(board,0,0);
    }
    private boolean solve(char [][] board , int r , int c){
        if(r == 9){
            return true;
        }
        if(c == 9){
            return solve(board, r+1, 0);
        }
        if(board[r][c] != '.'){
            return solve(board,r,c+1);
        }

        for(char ch = '1' ; ch <= '9' ; ch++){
            if(issafe(board,r,c,ch)){
                board[r][c] = ch;
                if(solve(board,r,c+1)){
                    return true;
                }
                board[r][c] = '.';
            }
        }
        return false;
    }
    private boolean issafe(char [][] board , int r , int c , char ch){
        for(int i = 0 ; i < 9 ; i++){
            if(board[r][i] == ch){
                return false;
            }
            if(board[i][c] == ch){
                return false;
            }
        }

        int nr = (r/3)*3;
        int nc = (c/3)*3;
        for(int i = nr ; i <= nr+2 ; i++){
            for(int j = nc ; j <= nc+2 ; j++){
                if(board[i][j] == ch){
                    return false;
                }
            }
        }
        return true;
    }

}