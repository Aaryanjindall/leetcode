class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> {
            if(a[0] == b[0])return (a[1]-b[1]);
            else{
                return a[0]-b[0];
            }
        });
        for(int i = 0 ; i < mat.length ; i++){
            int sol = 0;
            for(int j = 0 ; j < mat[0].length ; j++){
                if(mat[i][j] == 1){
                    sol++;
                }
            }
            // System.out.print(sol);
            pq.add(new int[]{sol,i});
        }
        int ans [] = new int [k];
        int id = 0;
        while(id < k && !pq.isEmpty()){
            int top[] = pq.poll();
            int ind = top[1];
            System.out.print(ind);
            ans[id++] = ind;
            
        }
        return ans;
    }
}