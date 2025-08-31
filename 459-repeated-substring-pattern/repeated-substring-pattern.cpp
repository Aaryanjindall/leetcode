class Solution {
public:
    bool repeatedSubstringPattern(string s) {
        string ans2 = (s + s).substr(1, 2 * s.length() - 2);
        return ans2.find(s) != string::npos;
    }
};