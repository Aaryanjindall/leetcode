class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        int n = graph.length;
        int color [] = new int[n];
        Arrays.fill(color,-1);
        //red -> 0
        //blue -> 1
        for(int i = 0 ; i < graph.length ; i++){
            if(color[i] != -1)continue;
            q.add(i);
            color[i] = 0;
            while(!q.isEmpty()){
                int curr = q.poll();
                if(color[curr] == -1){
                    color[curr] = 0;
                }
                for(int neigh : graph[curr]){
                    if(color[neigh] == -1){
                        color[neigh] = (color[curr] == 0)? 1 : 0;
                        q.add(neigh);
                    }
                    else if(color[neigh] == color[curr]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}