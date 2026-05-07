class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int j = 0;
        int max = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
            while(hm.get(nums[i])>k){
                hm.put(nums[j],hm.get(nums[j])-1);
                if(hm.get(nums[j]) == 0){
                    hm.remove(nums[j]);
                }
                j++;
            }
            int len = i-j+1;
            max = Math.max(max,len);
        }
        return max;
    }
}