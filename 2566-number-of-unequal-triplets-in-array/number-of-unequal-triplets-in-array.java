class Solution {
    public int unequalTriplets(int[] nums) {
        int n = nums.length;
        int count=0;
        for(int a = 0 ; a < n ; a++){
            for(int b = a+1 ; b < n ; b++){
                for(int c = b+1 ; c < n ; c++){
                    if((c>b) && (b>a)){
                        if((nums[c] != nums[b] ) && (nums[b] != nums[a]) && (nums[c] != nums[a])){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}