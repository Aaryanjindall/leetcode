class Solution {
    public int countGoodSubstrings(String s) {
        int j = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);

            // maintain window size = 3
            if (i - j + 1 > 3) {
                char leftChar = s.charAt(j);
                hm.put(leftChar, hm.get(leftChar) - 1);
                if (hm.get(leftChar) == 0) {
                    hm.remove(leftChar);
                }
                j++;
            }

            // check if window length == 3 and all distinct
            if (i - j + 1 == 3 && hm.size() == 3) {
                count++;
            }
        }

        return count;
    }
}
