class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0 ; i < t.length() ; i++){
            char ch = t.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        int count = t.length();
        int j = 0;
        int st = -1;
        int maxlen = Integer.MAX_VALUE;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(hm.containsKey(ch)){
                hm.put(ch,hm.get(ch)-1);
                if(hm.get(ch) >= 0){
                    count--;
                }
            }
            while(count == 0){
                int len = i-j+1;
                if(len < maxlen){
                    maxlen = len;
                    st = j;
                }
                char cha = s.charAt(j);
                if(hm.containsKey(cha)){
                    hm.put(cha,hm.get(cha)+1);
                    if(hm.get(cha)>0){
                        count++;
                    } 
                }
                j++;
            }
        }
        if(st == -1){
            return "";
        }
        return s.substring(st,st+maxlen);
    }
}