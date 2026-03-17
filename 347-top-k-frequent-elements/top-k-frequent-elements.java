class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int ans[] = new int[k];
        int idx = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int num : nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->hm.get(a)-hm.get(b));
        for(int key : hm.keySet()){
            pq.add(key);
            while(pq.size()>k){
                pq.poll();
            }
        }
        while(!pq.isEmpty()){
            ans[idx++] = pq.poll();
        }
        return ans;
    }
}