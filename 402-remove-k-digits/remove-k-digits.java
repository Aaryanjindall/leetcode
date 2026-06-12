class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < num.length() ; i++){
            char ch = num.charAt(i);
            while(!st.isEmpty() && k > 0 && st.peek()>ch){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while(k>0){
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();

        for(char ch : st) {
            sb.append(ch);
        }

        int idx = 0;

        while(idx < sb.length() && sb.charAt(idx) == '0') {
            idx++;
        }

        String ans = sb.substring(idx);

        return ans.length() == 0 ? "0" : ans;
    }
}