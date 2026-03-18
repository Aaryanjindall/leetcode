class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = m+n;
        int idx = nums1.length - m;
        for(int i = 0 ; i < idx ; i++){
            nums1[i+m] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}