class Solution {
    List<List<String>> list = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char [][] board = new char[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                board[i][j] = '.';
            }
        }
        solve(board,0);
        return list;
    }
    private void solve(char[][]board,int col){
        if(col == board[0].length){
            list.add(construct(board));
            return;
        }
        for(int r = 0 ; r < board.length ; r++){
            if(poss(board,r,col)){
                board[r][col] = 'Q';
                solve(board,col+1);
                board[r][col] = '.';
            }
        }
    }
    private boolean poss(char [][]board,int r , int c){
        for(int col = c ; col >= 0 ; col--){
            if(board[r][col] == 'Q'){
                return false;
            }
        }
        for(int row = r-1 , col = c-1 ; row >= 0 && col >= 0 ; row--,col--){
            if(board[row][col] == 'Q'){
                return false;
            }
        }
        for(int row = r+1 , col = c-1 ; row < board.length && col >= 0 ; row++,col--){
            if(board[row][col] == 'Q'){
                return false;
            }
        }
        return true;
    }
    private List<String> construct(char[][]board){
        List<String> temp = new ArrayList<>();
        for(int i = 0 ; i < board.length ; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j < board[0].length ; j++){
                sb.append(board[i][j]);
            }
            temp.add(sb.toString());
        }
        return temp;
    }

}