class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int j = 0;
        int maxlen = 0;
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            tm.put(nums[i],tm.getOrDefault(nums[i],0)+1);

            while(tm.lastKey() - tm.firstKey() > limit){
                tm.put(nums[j],tm.get(nums[j]) - 1);
                if(tm.get(nums[j]) == 0){
                    tm.remove(nums[j]);
                }
                j++;
            }
            maxlen = Math.max(maxlen , i-j+1);
        }
        return maxlen;
    }
}