class Solution {
    class Pair {
        int r, c, t;
        Pair(int row, int col, int time) {
            r = row;
            c = col;
            t = time;
        }
    }

    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int cntfresh = 0;

        Queue<Pair> q = new LinkedList<>();
        int [][] vis = new int[n][m];

        // Step 1: push all rotten oranges + count fresh
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }

                if (grid[i][j] == 1) {
                    cntfresh++;
                }
            }
        }

        int time = 0;
        int cnt = 0;

        int[] delrow = {-1, 0, +1, 0};
        int[] delcol = {0, +1, 0, -1};

        // Step 2: BFS
        while (!q.isEmpty()) {

            Pair p = q.poll();
            int r = p.r;
            int c = p.c;
            int t = p.t;

            time = Math.max(time, t);

            for (int i = 0; i < 4; i++) {
                int nrow = r + delrow[i];
                int ncol = c + delcol[i];

                if (nrow >= 0 && nrow < n &&
                    ncol >= 0 && ncol < m &&
                    grid[nrow][ncol] == 1 &&
                    vis[nrow][ncol] != 2) {

                    q.add(new Pair(nrow, ncol, t + 1));
                    vis[nrow][ncol] = 2;
                    cnt++;
                }
            }
        }

        // Final check
        if (cnt == cntfresh) return time;
        return -1;
    }
}
