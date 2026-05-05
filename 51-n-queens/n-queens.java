class Solution {
    List<List<String>> list = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        String board[][] = new String[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                board[i][j] = ".";
            }
        }
        solve(board,0);
        return list;
    }
    private void solve(String [][]board,int col){
        if(col == board.length){
            list.add(construct(board));
            return;
        }
        for(int r = 0 ; r < board.length ; r++){
            if(isvalid(board,r,col)){
                board[r][col] = "Q";
                solve(board,col+1);
                board[r][col] = ".";
            }
        }
    }
    private boolean isvalid(String [][]board,int r , int c){
        for(int col = c-1 ; col >= 0 ; col--){
            if(board[r][col].equals("Q")){
                return false;
            }
        }
        for(int col = c-1 , row = r-1 ; col>= 0 && row >= 0 ; col--,row--){
            if(board[row][col].equals("Q")){
                return false;
            }
        }
        for(int col = c-1 , row = r+1 ; col >= 0 && row < board.length ; col--,row++ ){
            if(board[row][col].equals("Q")){
                return false;
            }
        }
        return true;
    }
    private List<String> construct(String [][]board){
        List<String> temp = new ArrayList<>();
        for(int i = 0 ; i < board.length ; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j < board.length ; j++){
                sb.append(board[i][j]);
            }
            temp.add(sb.toString());
        }
        return temp;
    }
}