class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>());
        }
        for(int it[] : flights){
            int u = it[0];
            int v = it[1];
            int w = it[2];
            graph.get(u).add(new int[]{v,w});
        }
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.add(new int[]{0,src,0});
        int[][] dist = new int[n][k + 2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[src][0] = 0;



        while(!pq.isEmpty()){
            int top [] = pq.poll();
            int d = top[0];
            int u = top[1];
            int stop = top[2];
            if (stop > k) continue;
            for(int neigh[] : graph.get(u)){
                int v = neigh[0];
                int w = neigh[1];
                if(dist[u][stop]+w<dist[v][stop+1]){
                    dist[v][stop+1] = dist[u][stop]+w;
                    pq.add(new int[]{dist[v][stop+1],v,stop+1});
                }
            }
        }


        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i <= k+1 ; i++){
            ans = Math.min(ans, dist[dst][i]);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;


    }
}