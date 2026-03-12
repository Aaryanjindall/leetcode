class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        return solve(dp,word1,word2,0,0);
    }
    private int solve(int dp[][] , String word1 , String word2 , int i , int j){
        if(i == word1.length()){
            return word2.length()-j;
        }
        if(j == word2.length()){
            return word1.length()-i;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(word1.charAt(i) == word2.charAt(j)){
            return dp[i][j] = solve(dp,word1,word2,i+1,j+1);
        }
        int insert = solve(dp,word1,word2,i+1,j+1);
        int delete = solve(dp,word1,word2,i+1,j);
        int replace = solve(dp,word1,word2,i,j+1);

        return dp[i][j] = 1+Math.min(insert,Math.min(delete,replace));
    }
}