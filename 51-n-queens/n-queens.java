class Solution {
    List<List<String>> list = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for(char b[] : board){
            Arrays.fill(b,'.');
        }
        solve(board,0);
        return list;
    }
    private void solve(char board[][] , int c){
        if(c == board.length){
            list.add(construct(board));
            return;
        }
        for(int r = 0 ; r < board.length ; r++){
            if(isvalid(board,r,c)){
                board[r][c] = 'Q';
                solve(board,c+1);
                board[r][c] = '.';
            }
        }
    }
    private boolean isvalid(char board[][] , int r , int c){
        for(int col = c ; col >= 0 ; col--){
            if(board[r][col] == 'Q'){
                return false;
            }
        }
        for(int row = r , col = c ; row >= 0 && col >= 0 ; row--,col--){
            if(board[row][col] == 'Q'){
                return false;
            }
        }
        for(int row = r , col = c ; row < board.length && col >= 0 ; row++,col--){
            if(board[row][col] == 'Q'){
                return false;
            }
        }
        return true;
    }
    private List<String> construct(char [][] board){
        List<String> lister = new ArrayList<>();
        for(int i = 0 ; i < board.length ; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j < board.length ; j++){
                sb.append(board[i][j]);
            }
            lister.add(sb.toString());
        }
        return lister;
    }
}