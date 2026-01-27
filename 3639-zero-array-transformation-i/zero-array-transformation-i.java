class Solution {
    public boolean isZeroArray(int[] nums, int[][] que) {
        int n = nums.length;
        int res[] = new int[n];
        for(int i = 0 ; i < que.length ; i++){
            int a = que[i][0];
            int b = que[i][1];
            res[a] += 1;
            if(b+1 < n){
                res[b+1] -= 1;
            }
        }
        for(int i = 1 ; i < res.length ; i++){
            res[i] = res[i]+res[i-1];
        }
        for(int i = 0 ; i < res.length ; i++){
            if(res[i] < nums[i]){
                return false;
            }
        }
        return true;
    }
}