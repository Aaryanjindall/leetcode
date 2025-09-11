class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        
        // Map<stone position, set of jump sizes that can reach here>
        Map<Integer, Set<Integer>> dp = new HashMap<>();
        for (int stone : stones) {
            dp.put(stone, new HashSet<>());
        }
        
        dp.get(0).add(0); // frog starts at stone 0 with jump size 0
        
        for (int stone : stones) {
            for (int k : dp.get(stone)) {
                for (int jump = k - 1; jump <= k + 1; jump++) {
                    if (jump > 0 && dp.containsKey(stone + jump)) {
                        dp.get(stone + jump).add(jump);
                    }
                }
            }
        }
        
        return !dp.get(stones[n - 1]).isEmpty();
    }
}