class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> hs = new HashSet<>(wordDict);

        Boolean dp[] = new Boolean[s.length()];

        return solve(dp, hs, s, 0);
    }

    private boolean solve(Boolean dp[],
                          HashSet<String> hs,
                          String s,
                          int curr) {

        // Reached end
        if(curr == s.length()) {
            return true;
        }

        // Already computed
        if(dp[curr] != null) {
            return dp[curr];
        }

        // Try all substrings
        for(int i = curr; i < s.length(); i++) {

            String part = s.substring(curr, i + 1);

            if(hs.contains(part)) {

                if(solve(dp, hs, s, i + 1)) {
                    return dp[curr] = true;
                }
            }
        }

        return dp[curr] = false;
    }
}