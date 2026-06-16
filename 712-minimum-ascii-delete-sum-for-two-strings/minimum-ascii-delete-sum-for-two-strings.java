class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = s1.charAt(i-1)+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int lcs = dp[n][m];
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0 ; i < n ; i++){
            sum1 += (int)s1.charAt(i);
        }
        for(int i = 0 ; i < m ; i++){
            sum2 += (int)s2.charAt(i);
        }
        return sum1+sum2-2*lcs;

    }
}