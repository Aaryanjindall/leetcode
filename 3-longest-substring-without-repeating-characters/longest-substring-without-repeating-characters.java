class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int j = 0;
        int max = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            while(hm.get(ch)>1){
                char cha = s.charAt(j);
                hm.put(cha,hm.get(cha)-1);
                if(hm.get(cha) == 0){
                    hm.remove(cha);
                }
                j++;
            }
            int len = i-j+1;
            max = Math.max(len,max);
        }
        return max;
    }
}