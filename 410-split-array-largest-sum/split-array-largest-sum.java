class Solution {
    public int splitArray(int[] nums, int k) {
        int l = 0;
        int h = 0;
        for(int x : nums){
            l = Math.max(l,x);
            h += x;
        }
        while(l<=h){
            int mid = l+(h-l)/2;
            if(poss(mid,nums,k)){
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return l;
    }
    private boolean poss(int mid , int []nums , int k){
        int sum = 0;
        int ans = 1;
        for(int x : nums){
            if(x+sum > mid){
                sum = x;
                ans++;
            }
            else{
                sum += x;
            }
        }
        return ans <= k;
    }
}