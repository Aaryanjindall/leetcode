class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i < graph.length ; i++){
            list.add(new ArrayList<>());
        }
        
        int outdeg[] = new int[graph.length];
        for (int u = 0; u < graph.length; u++) {
            outdeg[u] = graph[u].length;  // original outdegree
            for (int v : graph[u]) {
                list.get(v).add(u);       // reverse edge
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 0 ; i < outdeg.length ; i++){
            if(outdeg[i] == 0){
                q.add(i);
            }
        }


        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);

            for (int prev : list.get(node)) {
                outdeg[prev]--;
                if (outdeg[prev] == 0) {
                    q.add(prev);
                }
            }
        }

        Collections.sort(ans);
        return ans;
    }
}