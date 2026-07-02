class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int sum = 0;
        int neg = 0;
        int min = Integer.MAX_VALUE;
        for(int i= 0 ; i < n ; i++){
            if(nums[i]<0){
                neg++;
            }
            sum += Math.abs(nums[i]);
            min = Math.min(min, Math.abs(nums[i]));
        }
        if(k <= neg){
            for(int i = 0 ; i < k ; i++){
                nums[i] = -nums[i];
            }
            int sum2 = 0;
            for(int x : nums){
                sum2 += x;
            }
            return sum2;
        }
        
        int rem = k-neg;
        if(rem % 2 == 0){
            return sum;
        }
        return sum - 2*min;
        

        


        // for(int i = 0 ; i < k ; i++){
        //     if(nums[i]<0){
        //         neg++;
        //     }
        //     nums[i] = -nums[i];
        // }
        // int sum = 0;
        // for(int x : nums){
        //     sum += x;
        // }
        // return sum;
    }
}