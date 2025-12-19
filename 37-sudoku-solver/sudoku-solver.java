class Solution {
    public void solveSudoku(char[][] board) {
        isvalid(board,0,0);
    }
    private boolean isvalid(char[][]board, int row , int col){
        if(row == 9){
            return true;
        }
        int nextRow = row;
        int nextcol = col+1;
        if(nextcol == 9){
            nextRow = row+1;
            nextcol = 0;
        }
        if(board[row][col] != '.'){
            return isvalid(board,nextRow,nextcol);
        }

        for(char ch = '1' ; ch <= '9' ;ch++){
            if(isSafe(board,row,col,ch)){
                board[row][col] = ch;
                if(isvalid(board,nextRow,nextcol)){
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;

    }
    private boolean isSafe(char board[][] , int row,int col , char ch){
        //horizontal check
        //vertical check
        for(int i = 0 ; i < 9 ; i++){
            if(board[row][i] == ch){
                return false;
            }
            if(board[i][col] == ch){
                return false;
            }
        }

        //box-check
        int sr = (row/3)*3;
        int sc = (col/3)*3;
        for(int i = sr ; i <= sr+2 ; i++){
            for(int j = sc ; j <= sc+2 ; j++){
                if(board[i][j] == ch){
                    return false;
                }
            }
        }
        return true;
    }
}