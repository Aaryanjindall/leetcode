class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int ans[] = new int[k];
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = nums.length;
        if(n == 1){
            return new int[]{nums[0]};
        }
        for(int i = 0 ; i < n ; i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->hm.get(b)-hm.get(a));
        for(int key : hm.keySet()){
            pq.add(key);
        }
        int idx = 0;
        while(!pq.isEmpty() && idx < k){
            ans[idx] = pq.poll();
            idx++;
        }
        return ans;

    }
}