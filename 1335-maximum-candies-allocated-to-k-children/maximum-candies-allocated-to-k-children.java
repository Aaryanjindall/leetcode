class Solution {
    public int maximumCandies(int[] can, long k) {
        long total = 0;
        int h = 0;

        for (int x : can) {
            total += x;
            h = Math.max(h, x);
        }

        if (total < k) return 0;

        int l = 1;
        int ans = 0;

        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (pos(can, k, mid)) {
                ans = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return ans;
    }

    private boolean pos(int[] can, long k, int mid) {
        long count = 0;

        for (int x : can) {
            count += x / mid;
        }

        return count >= k;
    }
}