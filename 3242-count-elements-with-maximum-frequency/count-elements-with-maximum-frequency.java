class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int num : nums){
            hm.put(num , hm.getOrDefault(num,0)+1); 
        }
        int maxfreq = Integer.MIN_VALUE;
        Set<Integer> keys = hm.keySet();

        for(int key : keys){
            maxfreq = Math.max(maxfreq,hm.get(key));
        }
        int count = 0;
        for(int i : keys){
            if(hm.get(i) == maxfreq){
                count ++;
            }
        }

        return count * maxfreq;

        
    }
}