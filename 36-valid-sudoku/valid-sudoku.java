class Solution {
    public boolean isValidSudoku(char[][] board) {
        return solve(board,0,0);
    }

    private boolean solve(char [][] board , int r , int c){

        if(r == 9){
            return true;
        }

        if(c == 9){
            return solve(board,r+1,0);
        }

        if(board[r][c] == '.'){
            return solve(board,r,c+1);
        }

        char ch = board[r][c];
        board[r][c] = '.';

        if(!isvalid(board,r,c,ch)){
            return false;
        }

        board[r][c] = ch;

        return solve(board,r,c+1); // ✅ FIX
    }

    private boolean isvalid(char board[][] , int r , int c , char ch){

        for(int i = 0 ; i < 9 ; i++){
            if(board[i][c] == ch) return false; // ✅ FIX
            if(board[r][i] == ch) return false; // ✅ FIX
        }

        int nr = (r/3)*3;
        int nc = (c/3)*3;

        for(int i = nr ; i <= nr+2 ; i++){
            for(int j = nc ; j <= nc+2 ; j++){
                if(board[i][j] == ch) return false; // ✅ FIX
            }
        }

        return true;
    }
}