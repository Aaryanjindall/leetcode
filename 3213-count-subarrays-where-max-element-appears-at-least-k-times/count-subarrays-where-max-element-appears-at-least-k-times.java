class Solution {
    public long countSubarrays(int[] nums, int k) {

        HashMap<Integer, Integer> hm = new HashMap<>();

        int n = nums.length;
        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }

        long totalSub = (long) n * (n + 1) / 2;

        int j = 0;
        long atMost = 0;

        for (int i = 0; i < n; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);

            while (hm.getOrDefault(max, 0) > k - 1) {
                hm.put(nums[j], hm.get(nums[j]) - 1);
                if (hm.get(nums[j]) == 0) {
                    hm.remove(nums[j]);
                }
                j++;
            }

            atMost += (i - j + 1);
        }

        return totalSub - atMost;
    }
}
