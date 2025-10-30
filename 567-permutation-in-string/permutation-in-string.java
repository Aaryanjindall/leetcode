class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] freq = new int[26];
        for (char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }

        int left = 0, right = 0, count = s1.length();

        while (right < s2.length()) {
            char r = s2.charAt(right);

            // if this char needed (freq > 0), decrease count
            if (freq[r - 'a'] > 0) count--;
            freq[r - 'a']--;
            right++;

            // when window size matches
            if (count == 0) return true;

            // if window size exceeds, move left pointer
            if (right - left >= s1.length()) {
                char l = s2.charAt(left);
                if (freq[l - 'a'] >= 0) count++;
                freq[l - 'a']++;
                left++;
            }
        }

        return false;
    }
}
