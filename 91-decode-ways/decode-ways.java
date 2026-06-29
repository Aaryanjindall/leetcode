class Solution {
    public int numDecodings(String s) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp,-1);
        return solve(s,dp,0);
    }
    private int solve(String s,int dp[],int cur){
        if(cur == s.length()){
            return 1;
        }
        if(s.charAt(cur) == '0'){
            return 0;
        }
        if(dp[cur] != -1){
            return dp[cur];
        }
        int take = solve(s,dp,cur+1);
        int skip = 0;
        if(cur+1<s.length()){
            int num = (s.charAt(cur)-'0')*10+(s.charAt(cur+1)-'0');
            if(num >= 10 && num <= 26){
                skip = solve(s,dp,cur+2);
            }
        }
        return dp[cur] = take+skip;
    }
}