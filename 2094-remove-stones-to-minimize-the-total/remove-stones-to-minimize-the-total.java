class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int n : piles){
            pq.add(n);
        }
        while(k > 0){
            int a = pq.remove();
            int floor = a/2;
            int b = a - floor;
            pq.add(b);
            k--;
        }

        int sum = 0;
        while(!pq.isEmpty()){
            sum += pq.remove();
        }

        return sum;


    }
}