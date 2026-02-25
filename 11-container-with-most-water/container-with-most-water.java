class Solution {
    public int maxArea(int[] height) {
        int s = 0;
        int e = height.length-1;
        int max = 0;
        while(s<e){
            int ht = Math.min(height[s],height[e]);
            int curr = ht*(e-s);
            max = Math.max(curr,max);
            if(height[s]<height[e]){
                s++;
            }
            else{
                e--;
            }
        }
        return max;
    }
}