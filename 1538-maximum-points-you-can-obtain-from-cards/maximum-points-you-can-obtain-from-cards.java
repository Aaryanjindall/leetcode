class Solution {
    public int maxScore(int[] cp, int k) {
        int lefts = 0;
        int rights = 0;
        int n = cp.length;
        for(int i = 0 ; i < k ; i++){
            lefts += cp[i];
        }
        int righti = n-1;
        int ans= lefts;
        for(int i = k-1 ; i>=0  ; i--){
            lefts -= cp[i];
            rights += cp[righti];
            righti--;
            ans = Math.max(ans,rights+lefts);
            
        }

        return ans;

    }
}