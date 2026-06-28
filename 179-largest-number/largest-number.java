class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        String []arr = new String[nums.length];
        int sum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            sum += nums[i];
            arr[i] = String.valueOf(nums[i]);
        }
        if(sum == 0){
            return "0";
        }
        
        Arrays.sort(arr,(a,b)->(b+a).compareTo(a+b));
        for(String s : arr){
            sb.append(s);
        }
        return sb.toString();
    }
}