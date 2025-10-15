class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b) -> Integer.compare(a.length(),b.length()));
        int dp[][] = new int[words.length][words.length +1];
        for(int row [] : dp){
            Arrays.fill(row,-1);
        }
        return solve(dp,words,0,-1);
    }
    private int solve(int [][]dp , String[]words, int i , int p){
        if(i >= words.length) return 0;
        if(dp[i][p+1]!= -1)return dp[i][p+1];
        int take = 0;
        if(p == -1 || pred(words[p],words[i])){
            take += 1 + solve(dp,words,i+1,i);
        }
        int skip = solve(dp,words,i+1,p);
        return dp[i][p+1] = Math.max(skip,take);
    }
    private boolean pred(String a , String b){
        int i = 0;
        int j = 0;
        while(i < a.length() && j < b.length()){
            if (b.length() - a.length() != 1) return false;
            if(a.charAt(i) == b.charAt(j)){
                i++;
            }
            j++;
        }
        return i == a.length();
    }
}