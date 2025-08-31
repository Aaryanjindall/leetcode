class Solution {
    public int appendCharacters(String s, String t) {
        int si = -1; // Tracks last matched index in s
        int st = 0;  // Pointer for t
        int x = 0;   // Count of characters to append

        while (st != t.length()) {
            // ❌ Problem 1: s.indexOf(t.charAt(st)) always gives first occurrence
            // This doesn't work if you've already matched that character earlier

            int idx = s.indexOf(t.charAt(st), si + 1); // ✅ FIX: search from si + 1

            if (idx == -1) {
                s = s + t.charAt(st); // Simulate append
                x++;
                si = s.length() - 1;  // ✅ Update si to new end
            } else {
                si = idx; // ✅ Move si forward to matched index
            }
            st++;
        }

        System.out.println(s);
        return x;
    }
}