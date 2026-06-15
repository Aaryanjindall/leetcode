class Solution {
    public int minEatingSpeed(int[] piles, int hours) {
        int l = 1;
        int h = 0;
        for(int x : piles){
            h = Math.max(x,h);
        }
        while(l<=h){
            int mid= l+(h-l)/2;
            if(poss(mid,piles,hours)){
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return l;
    }
    private boolean poss(int mid ,int[]piles ,int hour){
        long k = 0;
        for(int p : piles){
            k += p/mid;
            p = p%mid;
            if(p > 0){
                k++;
            }
        }
        return k <= hour;
    }
}