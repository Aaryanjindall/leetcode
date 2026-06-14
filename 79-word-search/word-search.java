class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(check(board,i,j,word,n,m,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean check(char[][]board,int i , int j , String word , int n , int m,int cur){
        if(cur == word.length()){
            return true;
        }
        if(i < 0 || j < 0 || i >= n || j >= m || word.charAt(cur) != board[i][j]){
            return false;
        }
        char save = board[i][j];
        board[i][j] = '#';
        boolean found = check(board,i+1,j,word,n,m,cur+1) || check(board,i,j+1,word,n,m,cur+1) || check(board,i-1,j,word,n,m,cur+1) || check(board,i,j-1,word,n,m,cur+1);
        board[i][j] = save;
        return found;
    }
}