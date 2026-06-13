class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int []ll = new int[n];
        int []rr = new int[n];
        Arrays.fill(ll,1);
        Arrays.fill(rr,1);
        for(int i = 1 ; i < n ; i++){
            if(ratings[i]>ratings[i-1]){
                ll[i] = ll[i-1]+1;
            }
        }
        for(int i = n-2 ; i>= 0 ; i--){
            if(ratings[i] >ratings[i+1]){
                rr[i] = rr[i+1]+1;
            }
        }
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            ans += Math.max(ll[i],rr[i]);
        }
        return ans;
    }
}