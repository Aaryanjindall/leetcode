class Solution {
    public boolean exist(char[][] board, String word){
        int n = board.length;
        int m = board[0].length;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(bt(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean bt(char [][] board , String word , int i , int j , int curr){
        if(curr == word.length()){
            return true;
        }
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(curr)){
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        boolean found = bt(board,word,i+1,j,curr+1) || bt(board,word,i,j+1,curr+1) || bt(board,word,i-1,j,curr+1) || bt(board,word,i,j-1,curr+1);
        board[i][j] = temp;
        return found;

    }
}