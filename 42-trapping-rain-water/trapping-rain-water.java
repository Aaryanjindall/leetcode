class Solution {
    public int trap(int[] height) {
        int ll [] = new int[height.length];
        int rr [] = new int[height.length];
        ll[0] = height[0];
        rr[rr.length-1] = height[height.length-1];
        for(int i = 1 ; i < height.length ; i++){
            ll[i] = Math.max(height[i],ll[i-1]);
        }
        for(int i = height.length-2 ; i >= 0 ; i--){
            rr[i] = Math.max(height[i],rr[i+1]);
        }
        int trap = 0;
        for(int i = 0 ; i < height.length ; i++){
            trap += (Math.min(ll[i],rr[i])-height[i]);
        }
        return trap;
    }
}