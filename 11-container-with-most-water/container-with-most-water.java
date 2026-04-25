class Solution {
    public int maxArea(int[] height) {
        int l  = 0;
        int h = height.length -1;
        int max = 0;
        while(l<h){
            int width = h-l;
            int hei = Math.min(height[h],height[l]);
            int water = width*hei;
            max = Math.max(water,max);
            if(height[l]<height[h]){
                l++;
            }
            else if(height[l]>height[h]){
                h--;
            }
            else{
                l++;
                h--;
            }
            
             
        }
        return max;
    }
}