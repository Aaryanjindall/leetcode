class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int nse[] = new int[n];
        int pse[] = new int[n];
        Stack<Integer> st = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        for(int i = n-1 ; i>= 0 ; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nse[i] = n;
            }
            else{
                nse[i] = st.peek();
            }
            st.push(i);
        }
        for(int i = 0 ; i < n ; i++){
            while(!st2.isEmpty() && (heights[st2.peek()] >= heights[i])){
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

        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            int h = heights[i];
            int w = nse[i]-pse[i]-1;
            int area = h*w;
            ans = Math.max(area,ans);
        }
        return ans;

    }
}