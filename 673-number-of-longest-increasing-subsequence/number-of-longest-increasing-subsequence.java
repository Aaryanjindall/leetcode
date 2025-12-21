import java.util.Arrays;

class Solution {
    int[] nums;
    int n;
    int[] len;
    int[] cnt;

    public int findNumberOfLIS(int[] nums) {
        this.nums = nums;
        this.n = nums.length;

        len = new int[n];
        cnt = new int[n];

        Arrays.fill(len, -1);
        Arrays.fill(cnt, -1);

        int maxlen = 0;
        for (int i = 0; i < n; i++) {
            maxlen = Math.max(maxlen, listen(i));
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (len[i] == maxlen) {
                ans += liscnt(i);
            }
        }
        return ans;
    }

    private int listen(int i) {
        if (len[i] != -1) return len[i];
        int best = 1;
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                best = Math.max(best, 1 + listen(j));
            }
        }
        return len[i] = best;
    }

    private int liscnt(int i) {
        if (cnt[i] != -1) return cnt[i];

        int ways = 0; // FIX: start from 0, not 1
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i] && len[j] + 1 == len[i]) {
                ways += liscnt(j);
            }
        }
        // If no predecessor contributes, count the subsequence [nums[i]] itself
        if (ways == 0) ways = 1;

        return cnt[i] = ways;
    }
}