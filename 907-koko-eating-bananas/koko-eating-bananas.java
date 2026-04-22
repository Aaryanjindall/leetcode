class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for(int p : piles){
            r = Math.max(r,p);
        }
        while(l<r){
            int mid = l+(r-l)/2;
            if(isvalid(piles,mid,h)){
                r = mid;
            }
            else{
                l = mid+1;
            }
        }
        return l;
    }
    private boolean isvalid(int []piles , int mid , int h){
        int sum = 0;
        for(int pile : piles){
            sum += (pile+mid-1)/mid;
        }
        return sum <= h;
    }
}