class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++){
            hs.add(nums[i]);
        }
        int max = 0;
        for(int n : hs){
            if(!hs.contains(n-1)){
                int curr = n;
                int len = 1;
                while(hs.contains(curr + 1)){
                    curr++;
                    len++;
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }
}