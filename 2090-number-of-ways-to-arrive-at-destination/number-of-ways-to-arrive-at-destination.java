import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {
        final int MOD = (int)1e9 + 7;

        // Step 1: Build graph (tera part same)
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>());
        }
        for(int road[] : roads){
            int u = road[0];
            int v = road[1];
            int w = road[2];
            graph.get(u).add(new int[]{v,w});
            graph.get(v).add(new int[]{u,w});
        }

        // Step 2: Distance and count arrays
        long[] dist = new long[n];
        long[] count = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        count[0] = 1;

        // Step 3: Priority Queue (tera part almost same)
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));
        pq.add(new long[]{0,0}); // {dist, node}

        // Step 4: Dijkstra loop
        while(!pq.isEmpty()){
            long top[] = pq.poll();
            long d = top[0];
            int u = (int)top[1];

            if(d > dist[u]) continue; // old entry ignore

            for(int neigh[] : graph.get(u)){
                int v = neigh[0];
                int w = neigh[1];

                // Shorter path found
                if(dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                    count[v] = count[u];
                    pq.add(new long[]{dist[v], v});
                }
                // Another shortest path found
                else if(dist[u] + w == dist[v]){
                    count[v] = (count[v] + count[u]) % MOD;
                }
            }
        }

        // Step 5: Return number of shortest paths to last node
        return (int)(count[n - 1] % MOD);
    }
}
