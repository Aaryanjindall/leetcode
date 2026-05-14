class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ll [] = new int[n];
        ll[0] = height[0];
        for(int i = 1 ; i < n ; i++){
            ll[i] = Math.max(ll[i-1],height[i]);
        }
        int rr[] = new int[n];
        rr[n-1] = height[n-1];
        for(int i = n-2 ; i >= 0 ; i--){
            rr[i] = Math.max(rr[i+1],height[i]);
        }
        int trap = 0;
        for(int i = 0 ; i < n ; i++){
            trap += Math.min(ll[i],rr[i]) - height[i];
        }
        return trap;
    }
}