class Solution {
    public int[][] insert(int[][] arr, int[] newarr) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = new int[]{newarr[0],newarr[1]};
        int n = arr.length;
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        int ans[][] = new int[n][2];
        int idx = 0;
        int start = arr[0][0];
        int end = arr[0][1];
        for(int i = 1 ; i < n ; i++){
            int s = arr[i][0];
            int e = arr[i][1];
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
        
        ans = Arrays.copyOf(ans,idx);
        return ans;
    }
}