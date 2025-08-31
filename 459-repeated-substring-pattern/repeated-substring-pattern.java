class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String ans = s+s;
        return ans.substring(1,ans.length()-1).contains(s);
    }
}