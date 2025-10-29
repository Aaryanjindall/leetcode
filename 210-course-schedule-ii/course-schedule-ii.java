class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (!dfs(graph, i, visited, path, stack)) {
                    return new int[0]; // cycle detected
                }
            }
        }

        int[] res = new int[numCourses];
        int idx = 0;
        while (!stack.isEmpty()) {
            res[idx++] = stack.pop();
        }
        return res;
    }

    private boolean dfs(List<List<Integer>> graph, int node, boolean[] visited, boolean[] path, Stack<Integer> stack) {
        visited[node] = true;
        path[node] = true;

        for (int next : graph.get(node)) {
            if (path[next]) return false; // cycle detected
            if (!visited[next]) {
                if (!dfs(graph, next, visited, path, stack)) return false;
            }
        }

        path[node] = false;
        stack.push(node); // add to topo order after exploring all children
        return true;
    }
}
