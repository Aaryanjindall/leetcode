class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int pl = p.length();
        int sl = s.length();
        int n = sl-pl;
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
            if(checkana(s.substring(i,i+pl),p)){
                list.add(i);
            }
        }
        return list;
    }
    private boolean checkana(String a , String p){
        if (a.length() != p.length()) return false;
        int freq[] = new int[26];
        for(int i = 0 ; i < a.length() ; i++){
            char ch = a.charAt(i);
            freq[ch-'a']++;
            char cha = p.charAt(i);
            freq[cha-'a']--;
        }
        for(int n : freq){
            if(n != 0){
                return false;
            }
        }
        return true;

    }
}