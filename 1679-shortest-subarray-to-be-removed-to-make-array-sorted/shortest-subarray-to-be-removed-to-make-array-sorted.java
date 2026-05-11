class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int l = 0;
        int r = arr.length-1;
        int n = arr.length;
        while(l+1<arr.length && arr[l]<=arr[l+1]){
            l++;
        }
        if(l==arr.length-1){
            return 0;
        }
        while(r > 0 && arr[r-1] <= arr[r]){
            r--;
        }
        int ans = Integer.MAX_VALUE;
        ans = Math.min(n-l-1,r);
        int i = 0;
        int j = r;
        while(i<=l && j <n ){
            if(arr[i]<=arr[j]){
                ans= Math.min(ans,j-i-1);
                i++;
            }
            else{
                j++;
            }
        }
        return ans;
    }
}