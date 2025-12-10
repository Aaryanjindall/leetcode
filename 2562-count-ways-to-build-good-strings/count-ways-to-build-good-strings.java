class Solution {
    static final int MOD = 1_000_000_007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int dp[] = new int[1000001];
        Arrays.fill(dp,-1);
        return solve(0,dp,low,high,zero,one);
    }
    private int solve(int curr , int []dp , int l , int h , int z , int o){
        if(curr > h){
            return 0;
        }
        if(dp[curr] != -1){
            return dp[curr];
        }
        long ways = 0;
        if(curr >= l && curr<= h){
            ways = 1;
        }
        long zero = solve(curr+z,dp,l,h,z,o);
        long one = solve(curr+o,dp,l,h,z,o);
        return dp[curr] = (int)(zero+one+ways)%MOD;
    }
}