class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        
        String board[][] = new String[n][n];
        //initialize
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                board[i][j] = ".";
            }
        }
        nqeens(board,0);
        return res;
    }
    private void nqeens(String board[][], int row){
        if(row == board.length){
            res.add(construct(board));
            return;
        }
        for(int i = 0 ; i < board.length ; i++){
            if(isvalid(board,row,i)){
                board[row][i] = "Q";
                nqeens(board,row+1);
                board[row][i] = ".";//backtrack
            } 
        }
    }
    private boolean isvalid(String board [][] , int row , int col){
        //vertical check
        for(int r = row-1 ; r >= 0 ; r--){
            if(board[r][col].equals("Q")){
                return false;
            }
        }
        //
        for(int r = row-1 ,c = col-1 ; r >= 0 && c>= 0 ; r-- , c--){
            if(board[r][c].equals("Q")){
                return false;
            }
        }
        for(int r = row-1,c = col+1 ; r>= 0 && c<board.length ; r--,c++ ){
            if(board[r][c].equals("Q")){
                return false;
            }
        }

        return true;
    }
    private List<String> construct(String[][] board){
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