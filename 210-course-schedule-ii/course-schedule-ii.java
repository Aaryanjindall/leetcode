class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++){
            list.add(new ArrayList<>());
        }
        for(int num [] : prerequisites){
            list.get(num[1]).add(num[0]);
        }
        boolean vis[] = new boolean[numCourses];
        boolean rec[] = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < numCourses ; i++){
            if(!vis[i]){
                if(!dfs(list,i,vis,rec,st)){
                    return new int [0];
                }
            }
        }
        int ans [] = new int[numCourses];
        int idx = 0;
        while(!st.isEmpty()){
            ans[idx++] = st.pop();
        }
        return ans;



    }
    private boolean dfs(List<List<Integer>> list , int curr , boolean[]vis , boolean[]rec, Stack<Integer> st){
        vis[curr] = true;
        rec[curr] = true;

        for(int neigh : list.get(curr)){
            if (!vis[neigh]) {
                if (!dfs(list, neigh, vis, rec, st)) return false;
        } else if (rec[neigh]) {  // yeh check bahar hona chahiye
            return false;
        }
        }
        rec[curr] = false;
        st.push(curr);
        return true;

    }
}