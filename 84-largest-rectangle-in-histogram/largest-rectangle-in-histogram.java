class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int nse [] = new int [n];
        int pse [] = new int [n];
        Stack<Integer> st1 = new Stack<>();
        for(int i = n-1 ; i >= 0 ; i--){
            while(!st1.isEmpty() && (heights[i] <= heights[st1.peek()])){
                st1.pop();
            }
            if(st1.isEmpty()){
                nse[i] = n;
            }
            else{
                nse[i] = st1.peek();
            }
            st1.push(i);
        }
        Stack<Integer> st2 = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            while(!st2.isEmpty() && (heights[i] <= heights[st2.peek()])){
                st2.pop();
            }
            if(st2.isEmpty()){
                pse[i] = -1;
            }
            else{
                pse[i] = st2.peek();
            }
            st2.push(i);
        }
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            int h = heights[i];
            int w = nse[i]-pse[i]-1;
            int area = h*w;
            max = Math.max(area,max);
        }
        return max;
    }
}