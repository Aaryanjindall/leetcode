class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        int j = 0;
        int sum = 0;
        int length = 0;
        int minlen = Integer.MAX_VALUE;
        for(int i = 0 ; i < arr.length ; i++){
            sum += arr[i];
            while(sum >= target){
                length = i-j+1;
                minlen = Math.min(minlen,length);
                sum -= arr[j];
                j++;
            }
            
             
            
        }
        return (minlen == Integer.MAX_VALUE)? 0 : minlen;
    }
}