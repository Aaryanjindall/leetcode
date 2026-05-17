class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int [word1.length()+1][word2.length()+1];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        return solve(dp,word1,word2,0,0);
        
    }
    private int solve(int dp[][],String word1 , String word2 , int s1 , int s2 ){
        if(s1 == word1.length()){
            return word2.length()-s2;
        }
        if(s2 == word2.length()){
            return word1.length()-s1;
        }
        if(dp[s1][s2] != -1){
            return dp[s1][s2];
        }
        if(word1.charAt(s1) == word2.charAt(s2)){
            return dp[s1][s2] = solve(dp,word1,word2,s1+1,s2+1);
        }
        int insert = solve(dp,word1,word2,s1,s2+1);
        int delete = solve(dp,word1,word2,s1+1,s2);
        int replace = solve(dp,word1,word2,s1+1,s2+1);
        return dp[s1][s2] = 1+Math.min(insert,Math.min(delete,replace));
    }
}