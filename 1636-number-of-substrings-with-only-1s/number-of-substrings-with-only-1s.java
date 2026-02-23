class Solution {
    public int numSub(String s) {
        int count = 0;
        int MOD = 1000000007;
        int ans = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '1'){
                count += 1;
                ans += count;
                ans = ans%MOD;
            }
            else{
                count = 0;
            }
        }
        return ans%MOD;
    }
}

// 11 111
// 1 1 11
// 1 1 1 11 11 111


// 11 => 3