class Solution {
    public int minZeroArray(int[] nums, int[][] queries){
        boolean alreadyZero = true;
        for (int x : nums) {
            if (x != 0) {
                alreadyZero = false;
                break;
            }
        }
        if (alreadyZero) return 0;
        int l = 0;
        int h = queries.length-1;
        int ans = -1;
        while(l <= h){
            int mid = l+(h-l)/2;
            if(check(nums,queries,mid)){
                ans = mid+1;
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return ans;
    }
    private boolean check(int [] nums, int [][]que , int mid){
        int n = nums.length;
        int res[] = new int[n+1];
        for(int i = 0; i <= mid ; i++){
            int a = que[i][0];
            int b = que[i][1];
            int k = que[i][2];
            res[a] += k;
            if(b+1 < n){
                res[b+1] -= k;
            }
        }

        for(int i = 1 ; i < n ; i++){
            res[i] += res[i-1];
        }

        for(int i = 0 ; i < n ; i++){
            if(res[i] < nums[i]){
                return false;
            }
        }
        return true;
    }
}