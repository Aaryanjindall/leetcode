class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[1],b[1]));
        int lastend = intervals[0][1];
        int cnt = 0;
        for(int i = 1 ; i < intervals.length ; i++){
            if(intervals[i][0] < lastend){
                cnt++;
            }
            else{
                lastend = intervals[i][1];
            }
        }
        return cnt;

    }
}