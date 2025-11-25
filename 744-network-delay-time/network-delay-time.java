class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
            graph.add(new ArrayList<>());
        }
        for(int it[] : times){
            int u = it[0];
            int v = it[1];
            int w = it[2];
            graph.get(u).add(new int[]{v,w});
        }
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);

        int dist[] = new int[n+1];
        Arrays.fill(dist,(int)1e9);
        dist[k] = 0;

        pq.add(new int[]{0,k});

        while(!pq.isEmpty()){
            int t [] = pq.poll();
            int d = t[0];
            int u = t[1];
            for(int it[] : graph.get(u)){
                int v = it[0];
                int w = it[1];
                if(w+dist[u] < dist[v]){
                    dist[v] = w+dist[u];
                    pq.add(new int[]{dist[v],v});
                }
            }
        }

        int ans = 0;
        for(int i = 1 ; i <= n ; i++){
            if(dist[i] == (int)1e9) return -1;   // unreachable
            ans = Math.max(ans, dist[i]);
        }

        return ans;

    }
}