class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] state = new int[n];  // 0 = not visited, 1 = visiting, 2 = safe
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (isSafe(i, graph, state))
                result.add(i);
        }
        return result;
    }

    private boolean isSafe(int node, int[][] graph, int[] state) {
        if (state[node] != 0)     // agar pehle se visited hai
            return state[node] == 2;  // safe hoga to true, warna false

        state[node] = 1;  // visiting mark
        for (int next : graph[node]) {
            if (!isSafe(next, graph, state))  // agar koi unsafe mila
                return false;
        }

        state[node] = 2;  // sab path safe nikle → mark safe
        return true;
    }
}
