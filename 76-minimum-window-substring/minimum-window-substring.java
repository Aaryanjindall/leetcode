class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        HashMap<Character, Integer> hm = new HashMap<>();

        // frequency map of t
        for (int k = 0; k < t.length(); k++) {
            char ch = t.charAt(k);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        int requiredCount = t.length();
        int i = 0, j = 0;

        int start = 0;
        int minLen = Integer.MAX_VALUE;

        while (j < s.length()) {
            char ch = s.charAt(j);

            if (hm.containsKey(ch)) {
                if (hm.get(ch) > 0) {
                    requiredCount--;
                }
                hm.put(ch, hm.get(ch) - 1);
            }

            // valid window found
            while (requiredCount == 0) {
                int currLen = j - i + 1;
                if (currLen < minLen) {
                    minLen = currLen;
                    start = i;
                }

                char leftChar = s.charAt(i);
                if (hm.containsKey(leftChar)) {
                    hm.put(leftChar, hm.get(leftChar) + 1);
                    if (hm.get(leftChar) > 0) {
                        requiredCount++;
                    }
                }
                i++;
            }
            j++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
