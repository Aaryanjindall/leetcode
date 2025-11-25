class Graph {
    List<List<int[]>> graph = new ArrayList<>();
    int N = 0;
    public Graph(int n, int[][] edges) {
        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>());
        }
        N = n;
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph.get(u).add(new int[]{v,w});
        }
    }
    public void addEdge(int[] edge){
        
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph.get(u).add(new int[]{v,w});
        
    }
    public int shortestPath(int n1, int n2) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        int dist[] = new int[N];
        Arrays.fill(dist,(int)1e9);
        dist[n1] = 0;
        pq.add(new int[]{0,n1});
        while(!pq.isEmpty()){
            int [] top = pq.poll();
            int d = top[0];
            int u = top[1];
            for(int nei[] : graph.get(u)){
                int v = nei[0];
                int w = nei[1];
                if(w+dist[u] < dist[v]){
                    dist[v] = w+dist[u];
                    pq.add(new int[]{dist[v],v});
                }
            }
            
        }
        
        return (dist[n2]==(int)1e9)? -1 : dist[n2];
    }
}
