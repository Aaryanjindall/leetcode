class Solution {
    public int minEatingSpeed(int[] piles, int r) {
        int l = 1;
        int max = 0;
        for(int m : piles){
            max = Math.max(m,max);
        }
        int h = max;
        while(l<h){
            int mid = l+(h-l)/2;
            if(poss(piles,r,mid)){
                h = mid;
            }
            else{
                l = mid+1;
            }
        }
        return l;
    }
    private boolean poss(int piles[] , int r , int mid){
        int k = 0;
        for(int p : piles){
            k += p/mid;
            int x = p%mid;
            if(x>0){
                k++;
            }
        }
        return k<=r;
    }
}