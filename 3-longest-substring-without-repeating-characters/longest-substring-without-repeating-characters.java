class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer>hm = new HashMap<>();
        int len  = 0 ;
        int maxlen = 0;
        int j = 0;
        for(int  i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            
            while(hm.get(ch)>1){
                char cha = s.charAt(j);
                hm.put(cha,hm.get(cha)-1);
                j++;
            }
            len = i-j+1;
            maxlen = Math.max(maxlen,len);
            
        }
        return maxlen;
    }
}