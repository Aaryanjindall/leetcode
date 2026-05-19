class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        for(int p[] : points){
            int x = p[0];
            int y = p[1];
            int d = (x-0)*(x-0)+(y-0)*(y-0);
            pq.add(new int[]{x,y,d});
        }
        int idx = 0;
        int ans[][] = new int [k][2];
        while(!pq.isEmpty() && idx < k){
            int curr[] = pq.poll();
            int currx = curr[0];
            int curry = curr[1];
            ans[idx][0] = currx;
            ans[idx][1] = curry;
            idx++;
        }
        return ans;
        
    }
}