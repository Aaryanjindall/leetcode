class Solution {
    public int smallestDivisor(int[] nums, int th) {
        int l = 1;
        int h = Integer.MIN_VALUE;
        for(int n : nums){
            h = Math.max(n,h);
        }
        while(l<=h){
            int mid = l+(h-l)/2;
            if(poss(nums,th,mid)){
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return l;
    }
    private boolean poss(int nums[] , int th , int mid){
        int k = 0;
        for(int n : nums){
            k += (n+mid-1)/mid;
        }
        return k<=th;
    }
}