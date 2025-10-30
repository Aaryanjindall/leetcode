class Solution {
    public int minNumberOperations(int[] target) {
        int a = 0;
        int l = 0;
        for(int i : target){
            a = a + Math.max(0,i-l);
            l = i;
        }
        return a;
    }
}