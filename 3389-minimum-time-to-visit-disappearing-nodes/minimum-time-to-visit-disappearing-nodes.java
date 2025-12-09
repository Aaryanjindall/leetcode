class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] dis) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        
        for (int[] row : edges) {
            int u = row[0], v = row[1], t = row[2];
            graph.get(u).add(new int[]{v, t});
            graph.get(v).add(new int[]{u, t});
        }
        
        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e9);
        
        dijkstra(graph, dis, dist);
        
        for (int i = 0; i < n; i++) {
            if (dist[i] == (int)1e9) dist[i] = -1;
        }
        
        return dist;
    }
    
    private void dijkstra(List<List<int[]>> graph, int[] dis, int[] dist) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        dist[0] = 0;
        pq.add(new int[]{0, 0});
        
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int d = top[0], u = top[1];
            
            if (d > dist[u]) continue; // skip outdated entries
            
            for (int[] neigh : graph.get(u)) {
                int v = neigh[0], w = neigh[1];
                int arrival = d + w;
                
                if (arrival >= dis[v]) continue; // node disappears
                
                if (arrival < dist[v]) {
                    dist[v] = arrival;
                    pq.add(new int[]{arrival, v});
                }
            }
        }
    }
}