class Solution {
    public int smallestNumber(int n) {
        int num = 1;        // start from 1
        while (num - 1 < n) {
            num = num * 2;  // keep doubling
        }
        return num - 1;     // answer is num - 1
    }
}