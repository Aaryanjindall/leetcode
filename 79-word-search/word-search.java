class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(bt(word,board,i,j,n,m,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean bt(String word , char [][] board , int i , int j , int n , int m , int curr){
        if(curr == word.length()){
            return true;
        }
        if(i < 0 || j < 0 || i >= n || j >= m || word.charAt(curr) != board[i][j]){
            return false;
        }
        char ch = board[i][j];
        board[i][j] = '#';
        boolean found = bt(word,board,i+1,j,n,m,curr+1) || bt(word,board,i,j+1,n,m,curr+1) || bt(word,board,i-1,j,n,m,curr+1) || bt(word,board,i,j-1,n,m,curr+1);
        board[i][j] = ch;
        return found;
    }
}