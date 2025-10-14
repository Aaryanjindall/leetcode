class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b) -> Integer.compare(a[0],b[0]));
        int dp[][] = new int[pairs.length][pairs.length+1];
        for(int []row : dp){
            Arrays.fill(row,-1);
        }
        return solve(pairs,dp,0,-1);
    }
    private int solve(int pairs[][] , int dp[][], int i , int p){
        if(i>=pairs.length){
            return 0;
        }
        if(dp[i][p+1] != -1){
            return dp[i][p+1];
        }
        int take = 0;
        if(p == -1 || pairs[p][1] < pairs[i][0]){
            take = 1 + solve(pairs,dp,i+1,i);
        }
        int skip = solve(pairs,dp,i+1,p);
        dp[i][p + 1] = Math.max(take, skip);

        return dp[i][p + 1];
    }

}