class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int s = nums[0];
        int l = nums[nums.length-1];
        return gcd(s,l);
    }
    private int gcd(int a , int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }

}