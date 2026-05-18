class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int sum1 = 0;
        int sum2 = 0;
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = s1.charAt(i - 1) +dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int lcs = dp[n][m];
        for(char ch : s1.toCharArray()){
            sum1 += (int)ch;
        }
        for(char ch : s2.toCharArray()){
            sum2 += (int)ch;
        }
        System.out.println(sum1+" "+sum2+ " "+lcs);
        return sum1+sum2-2*lcs;
    }
}