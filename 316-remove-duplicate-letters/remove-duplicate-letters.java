class Solution {
    public String removeDuplicateLetters(String s) {
        int lastidx[] = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
            lastidx[s.charAt(i)-'a'] = i;
        }
        boolean vis[] = new boolean[26];
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(vis[ch-'a']){
                continue;
            }
            while(!st.isEmpty() && st.peek()>ch && lastidx[st.peek()-'a']>i){
                vis[st.pop()-'a'] = false;
            }
            st.push(ch);
            vis[ch-'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}