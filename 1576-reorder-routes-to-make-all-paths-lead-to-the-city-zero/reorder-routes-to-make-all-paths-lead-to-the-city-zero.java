class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int []>> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            list.add(new ArrayList<>());
        }
        for(int []edge : connections){
            list.get(edge[0]).add(new int[]{edge[1],1});//yeh change hoga 
            list.get(edge[1]).add(new int[]{edge[0],0});//yeh nhi hoga change 
        }

        boolean vis [] = new boolean[n];
        return dfs(list , 0 , vis);


    }
    private int dfs(List<List<int []>> list , int node , boolean vis[]){
        vis[node] = true;
        int count = 0;
        for(int neigh[] : list.get(node)){
            int nextneigh = neigh[0];
            int needtochange = neigh[1];

            if(!vis[nextneigh]){
                count += needtochange + dfs(list,nextneigh,vis);
            }
        }
        return count;
    }
}