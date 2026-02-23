class Solution {
    public int longestConsecutive(int[] nums) {

        TreeMap<Integer,Integer> tm = new TreeMap<>();

        for(int i = 0 ; i < nums.length ; i++){
            tm.put(nums[i], 1);  // duplicate ignore ho jayenge
        }

        if(tm.size() == 0){
            return 0;
        }

        int longest = 1;
        int current = 1;
        Integer prev = null;

        for(int key : tm.keySet()){

            if(prev != null && key == prev + 1){
                current++;      // consecutive mila
            } else {
                current = 1;    // naya sequence start
            }

            longest = Math.max(longest, current);
            prev = key;
        }

        return longest;
    }
}