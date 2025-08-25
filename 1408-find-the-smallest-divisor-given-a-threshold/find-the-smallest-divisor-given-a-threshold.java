class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1;
        int h = Integer.MIN_VALUE;

        for(int num : nums){
            
            h = Math.max(h,num);

        }
        int ans = -1;
        while( l <= h ){
            int mid = l + (h-l)/2;
            long pos = possible(nums , threshold , mid);
            if(pos <= threshold){
                ans = mid;
                h = mid -1;
            }
            else{
                l = mid + 1;
            }

        }
        return ans;
    }
    private long possible(int []nums , int thresh , int a){
        long sum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            sum += (nums[i] + (long)a - 1)/a;
        }
        return sum;
    }
}