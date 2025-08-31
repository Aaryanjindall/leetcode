class Solution {
    public boolean repeatedSubstringPattern(String s) {
        
        String ans2=(s+s).substring(1,s.length()*2);
        if(ans2.indexOf(s)!=s.length()-1)return true;
        return false;
        // return ans.substring(1,ans.length()-1).contains(s);
    }
}

// abab -> bab|abab