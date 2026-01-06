class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        String[][] board = new String[n][n];

        // initialize with "."
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ".";
            }
        }

        solve(board, 0);   // start from column 0
        return res;
    }

    private void solve(String[][] board, int col) {
        // base case: all columns filled
        if (col == board.length) {
            res.add(construct(board));
            return;
        }

        // try each row in this column
        for (int row = 0; row < board.length; row++) {
            if (isValid(board, row, col)) {
                board[row][col] = "Q";
                solve(board, col + 1);
                board[row][col] = "."; // backtrack
            }
        }
    }

    private boolean isValid(String[][] board, int row, int col) {

        // same row - left side
        for (int c = col - 1; c >= 0; c--) {
            if (board[row][c].equals("Q")) {
                return false;
            }
        }

        // upper-left diagonal
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c].equals("Q")) {
                return false;
            }
        }

        // lower-left diagonal
        for (int r = row + 1, c = col - 1; r < board.length && c >= 0; r++, c--) {
            if (board[r][c].equals("Q")) {
                return false;
            }
        }

        return true;
    }

    private List<String> construct(String[][] board) {
        List<String> temp = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                sb.append(board[i][j]);
            }
            temp.add(sb.toString());
        }

        return temp;
    }
}
