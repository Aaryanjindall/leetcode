import java.util.*;

class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0)
            return 0;

        int n = heightMap.length;
        int m = heightMap[0].length;
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); // min heap (height based)

        // Step 1: Add all boundary cells
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, m - 1, heightMap[i][m - 1]});
            visited[i][0] = visited[i][m - 1] = true;
        }
        for (int j = 0; j < m; j++) {
            pq.offer(new int[]{0, j, heightMap[0][j]});
            pq.offer(new int[]{n - 1, j, heightMap[n - 1][j]});
            visited[0][j] = visited[n - 1][j] = true;
        }

        int water = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        // Step 2: Process cells in increasing order of height
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int r = cell[0], c = cell[1], h = cell[2];

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    // If neighbor is lower, it can trap water
                    if (heightMap[nr][nc] < h) {
                        water += h - heightMap[nr][nc];
                    }
                    // push with updated effective height
                    pq.offer(new int[]{nr, nc, Math.max(heightMap[nr][nc], h)});
                }
            }
        }
        return water;
    }
}
