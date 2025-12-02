class Solution {
    public int minCostConnectPoints(int[][] points) {

        int n = points.length;
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);

        pq.add(new int[]{0,0});
        boolean vis[] = new boolean[points.length];
        int total = 0;

        while(!pq.isEmpty()){
            int curr [] = pq.poll();
            int d = curr[0];
            int u = curr[1];
            if(vis[u])continue;
            vis[u] = true;
            total += d;
            for(int i = 0 ; i < points.length ; i++){
                if(!vis[i]){
                    int dist = Math.abs(points[u][0] - points[i][0]) + Math.abs(points[u][1] - points[i][1]);
                    pq.add(new int[]{dist,i});
                }
            }
        }

        return total;


    }
}