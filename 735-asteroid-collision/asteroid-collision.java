class Solution {
    public int[] asteroidCollision(int[] ast) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < ast.length ; i++){
            while(!st.isEmpty() && ast[i]<0 && st.peek() > 0){
                int sum = st.peek()+ast[i];
            if(sum < 0){
                st.pop();
            }
            else if(sum > 0){
                ast[i] = 0;
            }
            else{
                ast[i] = 0;
                st.pop();
            }
            }
            
            if(ast[i] != 0){
                st.push(ast[i]);
            }
        }
        int ans[] = new int[st.size()];
        int idx = st.size()-1;
        while(!st.isEmpty()){
            ans[idx] = st.pop();
            idx--;
        }
        return ans;

    }
}