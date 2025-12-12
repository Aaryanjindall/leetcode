class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
        for(int i = 0 ; i < intervals.length ; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(list.isEmpty() || list.get(list.size()-1)[1] < start){
                list.add(new int[]{start,end});
            }
            else{
                list.get(list.size()-1)[1] = Math.max(end,list.get(list.size()-1)[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}