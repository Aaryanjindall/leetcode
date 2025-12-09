class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int indeg[] = new int[n];
        // int outdeg[] = new int[n];
        for(int road [] : roads){
            int u = road[0];
            int v = road[1];
            indeg[u]++;
            indeg[v]++;
        }

        Arrays.sort(indeg);
        long total = 0;
        int val = 1;
        for(int deg : indeg){
            total += (long)deg*val;
            val++;
        }
        return total;
    }
}