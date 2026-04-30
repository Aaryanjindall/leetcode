class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        // step 1: add all elements
        for(int num : nums){
            set.add(num);
        }

        int max = 0;

        // step 2: check only sequence starts
        for(int num : set){
            if(!set.contains(num - 1)){   // start of sequence
                int curr = num;
                int len = 1;

                // step 3: build sequence
                while(set.contains(curr + 1)){
                    curr++;
                    len++;
                }

                max = Math.max(max, len);
            }
        }

        return max;
    }
}