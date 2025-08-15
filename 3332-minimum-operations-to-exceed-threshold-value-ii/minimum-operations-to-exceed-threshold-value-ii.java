class Solution {
    public int minOperations(int[] nums, int k) {
        int op = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int num : nums){
            pq.add((long) num);
        }
        while(pq.size() > 1 && pq.peek() < k){
            
            long a = pq.remove();
            long b = pq.remove();
            long newval = a*2 + b;
            pq.add(newval);
            op++;
            
        }

       return op;
    }
}