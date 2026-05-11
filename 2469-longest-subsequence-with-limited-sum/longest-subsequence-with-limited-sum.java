class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int ans[] = new int[queries.length];
        Arrays.sort(nums);
        for(int i = 1 ; i < nums.length ; i++){
            nums[i] = nums[i-1]+nums[i];
        }
        for(int i = 0 ; i < queries.length ; i++){
            int count = 0;
            int l = 0;
            int h = nums.length-1;
            int tar = queries[i];
            while(l<=h){
                int mid = l+(h-l)/2;
                if(nums[mid]<=tar){
                    count = mid+1;
                    l = mid+1;
                }
                else{
                    h = mid-1;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
}