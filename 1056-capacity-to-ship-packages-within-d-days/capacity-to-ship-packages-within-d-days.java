class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0;
        int h = 0;
        for(int w : weights){
            h += w;
            l = Math.max(l,w);
        }
        while(l<=h){
            int mid = l+(h-l)/2;
            if(poss(weights,days,mid)){
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return l;
    }
    private boolean poss(int []arr , int days , int mid){
        int k = 1;
        int sum = 0;
        for(int a : arr){
            if(sum+a > mid){
                sum = a;
                k++;
            }
            else{
                sum += a;
            }
        }
        return k<=days;
    }
}