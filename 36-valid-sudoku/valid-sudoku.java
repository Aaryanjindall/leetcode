class Solution {
    public boolean isValidSudoku(char[][] board) {
        return isvalid(board,0,0);
    }
    private boolean isvalid(char[][]board , int row , int col){
        if(row == 9){
            return true;
        }
        int nextrow = row;
        int nextcol = col+1;
        if(nextcol == 9){
            nextcol = 0;
            nextrow = row+1;
        }

        if(board[row][col] == '.'){
            return isvalid(board,nextrow,nextcol);
        }
        char ch = board[row][col];
        board[row][col] = '.';
        if(!issafe(board,row,col,ch)){
            return false;
        }
        board[row][col] = ch;
        return isvalid(board,nextrow,nextcol);
    }
    private boolean issafe(char[][]board,int row,int col , char ch){
        //horizontal and vertical check
        for(int i = 0 ; i < 9 ; i++){
            if(board[row][i] == ch){
                return false;
            }
            if(board[i][col] == ch){
                return false;
            }
        }


        //ab box check
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