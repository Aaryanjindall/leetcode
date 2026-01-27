class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int l = 0, h = queries.length, ans = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (check(nums, queries, mid)) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private boolean check(int[] nums, int[][] que, int count) {
        int n = nums.length;
        int[] res = new int[n + 2]; // safer size
        for (int i = 0; i < count; i++) {
            int a = que[i][0], b = que[i][1], k = que[i][2];
            res[a] += k;
            res[b + 1] -= k;
        }
        for (int i = 1; i < n; i++) res[i] += res[i - 1];
        for (int i = 0; i < n; i++) if (res[i] < nums[i]) return false;
        return true;
    }
}