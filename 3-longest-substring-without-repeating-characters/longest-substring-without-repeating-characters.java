class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[256];
        Arrays.fill(hash, -1); // initialize all to -1

        int l = 0, r = 0;
        int maxlen = 0;

        while (r < s.length()) {
            char ch = s.charAt(r);

            if (hash[ch] != -1 && hash[ch] >= l) {
                l = hash[ch] + 1; // move left pointer
            }

            hash[ch] = r; // update last seen index
            maxlen = Math.max(maxlen, r - l + 1);
            r++;
        }

        return maxlen;
    }
}
