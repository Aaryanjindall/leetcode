class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        // range of sum = -1000 to +1000
        int offset = 1000;
        int dp[][] = new int[n][2001];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        return solve(nums, 0, 0, target, dp, offset);
    }

    private int solve(int[] nums, int i, int curr, int target, int[][] dp, int offset) {

        // base case: last element processed
        if (i == nums.length) {
            return curr == target ? 1 : 0;
        }

        // dp check
        if (dp[i][curr + offset] != Integer.MIN_VALUE) {
            return dp[i][curr + offset];
        }

        // two choices: + or -
        int plus = solve(nums, i + 1, curr + nums[i], target, dp, offset);
        int minus = solve(nums, i + 1, curr - nums[i], target, dp, offset);

        return dp[i][curr + offset] = plus + minus;
    }
}
