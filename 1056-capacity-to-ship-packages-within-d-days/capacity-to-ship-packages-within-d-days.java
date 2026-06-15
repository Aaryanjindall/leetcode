class Solution {
    public int shipWithinDays(int[] w, int d) {
        int l = 1;
        int h = 0;
        for(int x : w){
            h += x;
            l = Math.max(l, x);
        }
        while(l<=h){
            int mid = l+(h-l)/2;
            if(poss(mid,w,d)){
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return l;
    }
    private boolean poss(int mid , int w[] , int d){
        int k = 1;
        int sum = 0;
        for(int i = 0 ; i < w.length ; i++){
            if(sum + w[i] > mid){
                sum = w[i];
                k++;
            }
            else{
            sum += w[i];
            }
        }
        return k <= d;
    }
}