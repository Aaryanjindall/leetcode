class Solution {
    public int[][] merge(int[][] inter) {
        int n = inter.length;
        int m = inter[0].length;
        int ans[][] = new int[n][m];
        Arrays.sort(inter, (a,b) -> Integer.compare(a[0], b[0]));
        int start = inter[0][0];
        int end = inter[0][1];
        int idx = 0;
        for(int i = 1 ; i < n ; i++){
            int s = inter[i][0];
            int e = inter[i][1];
            if(s<=end){
                end = Math.max(e,end);
            }
            else{
                ans[idx][0] = start;
                ans[idx][1] = end;
                idx++;
                start = s;
                end = e;
            }
        }
        ans[idx][0] = start;
        ans[idx][1] = end;
        idx++;
        return Arrays.copyOf(ans,idx);
    }
}