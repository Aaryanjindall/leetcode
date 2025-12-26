class Solution {
    public int threeSumClosest(int[] nums, int tar) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        int n = nums.length;
        for(int i = 0 ; i < nums.length - 2 ; i++){
            if(i > 0 && nums[i]== nums[i-1])continue;
            int j = i+1;
            int k = n-1;
            while(j < k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum == tar){
                    if(Math.abs(sum-tar)<Math.abs(closest-tar)){
                        closest = sum;
                    }
                    
                    while((j<k) && nums[j] == nums[j+1])j++;
                    j++;
                    while((j<k) && nums[k] == nums[k-1])k--;
                    k--;
                }
                else if(sum < tar){
                    if(Math.abs(sum-tar)<Math.abs(closest-tar)){
                        closest = sum;
                    }
                    j++;
                }
                else{
                    if(Math.abs(sum-tar)<Math.abs(closest-tar)){
                        closest = sum;
                    }
                    k--;
                }
            }
            
        }
        return closest;

    }
}