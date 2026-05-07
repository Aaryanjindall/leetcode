class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1l = s1.length();
        int s2l = s2.length();
        int n = s2l-s1l;
        for(int i = 0 ; i <= n ; i++){
            if(check(s2.substring(i,i+s1l),s1)){
                return true;
            }
        }
        return false;
    }
    private boolean check(String s , String p){
        int fre[] = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            fre[ch-'a']++;
            char cha = p.charAt(i);
            fre[cha-'a']--;
        }
        for(int i : fre){
            if(i != 0){
                return false;
            }
        }
        return true;

    }
}