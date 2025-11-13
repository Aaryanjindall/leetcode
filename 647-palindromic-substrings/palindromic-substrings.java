class Solution {
    int count;
    public int countSubstrings(String s) {
        int n = s.length();
        int dp[][] = new int[1001][1001];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        for(int i = 0 ; i < s.length() ; i++){
            for(int j = i ; j < s.length() ; j++){
                if(solve(dp,s,i,j)==1){
                    count++;
                }
            }
        }
        return count;
        
    }
    private int solve(int dp[][] , String a , int i , int j ){
        if(i > j){
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(a.charAt(i) == a.charAt(j)){
            return dp[i][j] = solve(dp,a,i+1,j-1);
        }
        return dp[i][j] = -1;
    } 
    
}