class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i <=n ; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] pair : dislikes) {
            graph.get(pair[0]).add(pair[1]);
            graph.get(pair[1]).add(pair[0]);
        }

        int [] color = new int[n+1];
        Arrays.fill(color , -1);
        
        for(int i = 1; i <= n ; i++){
            if(color[i] == -1){
                if(!bfs(graph , i , color)){
                    return false;
                }
            }
        }
        return true;

        
    }
    private boolean bfs(ArrayList<ArrayList<Integer>>graph , int i , int []color){
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        color[i] = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int neigh : graph.get(node)){
                if(color[neigh] == -1){
                    color[neigh] = 1 - color[node];
                    q.add(neigh);
                }
                else if(color[neigh] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }
}