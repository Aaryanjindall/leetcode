class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs = new HashSet<>(wordDict);
        Boolean []dp = new Boolean[s.length()];
        return solve(dp,hs,wordDict,s,0);
    }
    private boolean solve(Boolean []dp,HashSet<String> hs , List<String> list ,String s, int curr){
        if(curr == s.length()){
            return true;
        }
        if(dp[curr] != null){
            return dp[curr];
        }
        for(int i = curr ; i < s.length() ; i++){
            String part = s.substring(curr,i+1);
            if(hs.contains(part)){
                if(solve(dp,hs,list,s,i+1)){
                    return dp[curr] = true;
                }
            }
        }
        return dp[curr] = false;
    }
}