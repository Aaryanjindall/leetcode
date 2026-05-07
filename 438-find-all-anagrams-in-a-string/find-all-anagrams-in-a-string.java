class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int sl = s.length();
        int pl = p.length();
        int n = sl-pl;
        for(int i = 0 ; i <= n ; i++){
            if(check(s.substring(i,i+pl),p)){
                list.add(i);
            }
        }
        return list;
    }
    private boolean check(String p , String s){
        int freq[] = new int[26];
        for(int i = 0 ; i < p.length() ; i++){
            char ch = p.charAt(i);
            freq[ch-'a']++;
            char cha = s.charAt(i);
            freq[cha-'a']--;
        }
        for(int i : freq){
            if(i != 0){
                return false;
            }
        }
        return true;
    }
}