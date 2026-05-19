class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int n = stones.length;
        for(int i = 0 ; i < n ; i++){
            pq.add(stones[i]);
        }
        while(!pq.isEmpty() && pq.size() >= 2){
            int y = pq.poll();
            int x = pq.poll();
            if(y>x){
                pq.add(y-x);
            }
        }
        return (pq.size() != 0)? pq.peek() : 0;
    }
}