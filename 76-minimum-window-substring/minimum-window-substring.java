class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()){
            return "";
        }
        int count = t.length();
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0 ; i < t.length() ; i++){
            hm.put(t.charAt(i),hm.getOrDefault(t.charAt(i),0)+1);
        }
        int j = 0;
        int st = 0;
        int len = 0;
        int minlen = Integer.MAX_VALUE;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(hm.containsKey(ch)){
                if(hm.get(ch)>0){
                    count--;
                }
                hm.put(ch,hm.get(ch)-1);
            }
            while(count == 0){
                len = i-j+1;
                if(len < minlen){
                    st = j;
                    minlen = len;
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
        if(minlen == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(st,st+minlen);
    }
}