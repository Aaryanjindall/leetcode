class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[temp.length];
        for(int i = n-1 ; i >= 0  ; i--){
            while(!st.isEmpty() && (temp[i] >= temp[st.peek()])){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = 0;
            }
            else{
                int x = st.peek()-i;
                ans[i] = x;
            }
            st.push(i);
        }
        // int idx = temp.length-1;
        // while(!st.isEmpty()){
        //     ans[idx--] = st.pop();
        // }
        return ans;
    }
}