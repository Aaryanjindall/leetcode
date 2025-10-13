class Solution {
    public int countGoodSubstrings(String s) {
        int j = 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            while(i - j + 1 > 3 || hm.get(ch)>1){
                char cha = s.charAt(j);
                hm.put(cha,hm.get(cha)-1);
                if(hm.get(cha)==0){
                    hm.remove(cha);
                }
                j++;
                
            }
            if(i - j + 1 == 3 && hm.size()==3){
                count++;
                }
            
        }
        return count;

    }

}