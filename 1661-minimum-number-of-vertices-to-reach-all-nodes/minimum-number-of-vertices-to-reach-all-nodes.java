class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int indeg[] = new int[n];

        for(List<Integer>edge : edges){
            int i = edge.get(1);
            indeg[i]++;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                res.add(i);
            }
        }

        return res;
    }
}