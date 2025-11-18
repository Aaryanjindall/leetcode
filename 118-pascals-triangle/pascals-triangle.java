class Solution {
    public List<List<Integer>> generate(int rows) {
        
        int dp[][] = new int [rows+1][rows+1];

        for(int []row : dp){
            Arrays.fill(row,-1);
        }
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0 ; i < rows ; i++){
            List<Integer> ans = new ArrayList<>();
            for(int k = 0 ; k <= i ; k++){
                ans.add(solve(dp,i,k));
            }
            list.add(ans);

        }
        return list;

        
    }
    private int solve(int [][] dp , int i , int j){
        if(j == 0 || j == i)return 1;
        if(dp[i][j] != -1)return dp[i][j];

        dp[i][j] = solve(dp,i-1,j-1)  + solve(dp,i-1,j);
        return dp[i][j];
    }
}