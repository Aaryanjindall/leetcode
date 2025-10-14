class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int n = s.length();
        int[] count = new int[2]; // count[0] for '0', count[1] for '1'
        int left = 0, total = 0;

        for (int right = 0; right < n; right++) {
            count[s.charAt(right) - '0']++;

            while (count[0] > k && count[1] > k) {
                count[s.charAt(left) - '0']--;
                left++;
            }

            total += right - left + 1;
        }

        return total;
    }
}