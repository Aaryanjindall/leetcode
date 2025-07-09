class Solution {
    public int minScore(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0], v = road[1], d = road[2];
            graph.get(u).add(new int[]{v, d});
            graph.get(v).add(new int[]{u, d});
        }
        boolean vis[] = new boolean[n + 1];
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.add(new int[]{1,Integer.MAX_VALUE});

        int minscore = Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            int [] curr = pq.remove();
            int node = curr[0];
            if(vis[node])continue;
            vis[node]= true;

            for(int [] neigh : graph.get(node)){
                int next = neigh[0];
                int dist = neigh[1];
                minscore = Math.min(minscore , dist);

                if(!vis[next]){
                    pq.add(new int[]{next , dist});
                }

            }


        }
        return minscore;


    }
}