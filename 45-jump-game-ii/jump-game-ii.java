class Solution {
    public int jump(int[] nums) {
        int maxjump = 0;
        int jumps = 0;
        int currend = 0;
        for(int i = 0 ; i < nums.length-1 ; i++){
            maxjump = Math.max(maxjump,i+nums[i]);

            if(i == currend)
            {   
                jumps++;
                currend = maxjump;
            }
        }
        return jumps;
    }
}