    class Solution {
        public int maximumLengthSubstring(String s) {
            int j = 0;
            int maxlen = 0;
            HashMap<Character,Integer> hm = new HashMap<>();
            for(int i = 0 ; i < s.length() ; i++){
                char ch = s.charAt(i);
                hm.put(ch,hm.getOrDefault(ch,0)+1);
                while(hm.get(ch)>2){
                    char cha = s.charAt(j);
                    hm.put(cha,hm.get(cha)-1);
                    if(hm.get(cha) == 0){
                        hm.remove(cha);
                    }
                    j++;
                }
                maxlen = Math.max(maxlen,i-j+1);

            }
            return maxlen;
        }
    }