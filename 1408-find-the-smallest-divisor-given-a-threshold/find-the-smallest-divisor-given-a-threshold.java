class Solution {
    public int smallestDivisor(int[] nums, int th) {
        int l = 1;
        int r = 0;
        for(int n : nums){
            r = Math.max(r,n);
        }
        while(l<r){
            int mid = l+(r-l)/2;
            if(find(nums,mid,th)){
                r = mid;
            }
            else{
                l = mid+1;
            }
        }
        return l;
    }
    private boolean find(int []nums , int mid , int th){
        int sum = 0;
        for(int x : nums){
            sum += (x+mid-1)/mid;
        }
        return sum <= th;
    }
}