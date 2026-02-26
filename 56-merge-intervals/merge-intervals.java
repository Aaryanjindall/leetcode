class Solution {
    public int[][] merge(int[][] intervals){
        int n = intervals.length;
        if(n == 1){
            return intervals;
        }
        int ans[][] = new int[n][2];
        Arrays.sort(intervals , (a,b)->a[0]-b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        int idx = 0;
        for(int i = 1 ; i < n ; i++){
            int s = intervals[i][0];
            int e = intervals[i][1];
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