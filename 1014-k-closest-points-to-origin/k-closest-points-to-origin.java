class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        for(int [] point : points){
            int x = point[0];
            int y = point[1];
            int d = (x - 0)*(x-0)+(y-0)*(y - 0);
            pq.add(new int[]{d,x,y});
        }

        int [][] ans = new int[k][2];
        int idx = 0;
        while(idx < k && !pq.isEmpty()){
            int [] top = pq.poll();
            int x = top[1];
            int y = top[2];
            System.out.println(x +" " + y);
            ans[idx][0] = x;
            ans[idx][1] = y;
            idx++;
        }
        return ans;


    }
}