class Solution {
    public int[] countBits(int n) {
        int res []  = new int[n+1];
        res[0] = 0;
        for(int i = 1 ; i <= n ; i++){
            int count = 0;
            int k = i;
            while(k!=0){
                if((k & 1) == 1){
                    count++;
                }
                k >>= 1;
            }
            res[i] = count;
        }
        
        return res;
    }
}