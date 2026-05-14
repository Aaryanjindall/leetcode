class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k){
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>());
        }
        for(int f[] : flights){
            int u = f[0];
            int v = f[1];
            int w = f[2];
            graph.get(u).add(new int[]{v,w});
        }
        int dist[][] = new int[n][k+2];
        for(int d[] : dist){
            Arrays.fill(d,(int)1e9);
        }
        dist[src][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,src,0});
        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int w = curr[0];
            int u = curr[1];
            int stop = curr[2];
            if(u == dst){
                return w;
            }
            if(stop+1 > k+1){
                continue;
            }
            for(int neigh[] : graph.get(u)){
                int next = neigh[0];
                int weight = neigh[1];
                if(w+weight < dist[next][stop+1]){
                    dist[next][stop+1] = w+weight;
                    pq.add(new int[]{dist[next][stop+1],next,stop+1});
                }
            }
        }
        return -1;
        
    }
}