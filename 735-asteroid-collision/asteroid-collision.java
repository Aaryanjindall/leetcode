class Solution {
    public int[] asteroidCollision(int[] ast) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < ast.length ; i++){
            while(!st.isEmpty() && st.peek() > 0 && ast[i]<0){
                if(st.peek() > Math.abs(ast[i])){
                    ast[i] = 0;
                }
                else if(st.peek()< Math.abs(ast[i])){
                    st.pop();
                }
                else{
                    st.pop();
                    ast[i] = 0;
                }
            }
            if(ast[i] != 0){
                st.push(ast[i]);
            }
        }
        int ans[] = new int[st.size()];
        int idx= st.size()-1;
        while(!st.isEmpty()){
            ans[idx--] = st.pop();
        }
        return ans;
    }
}