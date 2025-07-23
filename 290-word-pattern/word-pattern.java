class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split("\\s+");
        if (words.length != pattern.length()) return false;
        
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = words[i];
            
            if (map.containsKey(c)) {
                if (!map.get(c).equals(w)) return false; // mismatch
            } else {
                if (set.contains(w)) return false; // word already mapped to another char
                map.put(c, w);
                set.add(w);
            }
        }
        
        return true;
    }
}
