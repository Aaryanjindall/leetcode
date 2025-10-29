class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++){
            list.add(new ArrayList<>());

        }
        for(int num[] : prerequisites){
            list.get(num[1]).add(num[0]);
        }

        boolean vis[] = new boolean [numCourses];
        boolean recstack[] = new boolean [numCourses];

        for(int i = 0 ; i < numCourses ; i++){
            if(!vis[i]){
                if(dfs(list,vis,recstack,i)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs(List<List<Integer>> list , boolean vis[] , boolean recstack[] , int curr){
        vis[curr] = true;
        recstack[curr] = true;

        for(int neigh : list.get(curr)){
            if(!vis[neigh]){
                if(dfs(list,vis,recstack,neigh)){
                    return true;
                }
            }
            else if(recstack[neigh]){
                return true;
            }
        }

        recstack[curr] = false;//backtrack karte time
        return false;


    }
}