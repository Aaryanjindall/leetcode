class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min = Integer.MIN_VALUE;
        int max = 0;
        for(int w : weights){
            min = Math.max(min,w);
            max += w;
        }
        while(min < max){
            int mid = min+(max-min)/2;
            if(find(weights,days,mid)){
                max = mid;
            }
            else{
                min = mid+1;
            }
        }
        return min;

    }
    private boolean find(int w[] , int days , int mid){
        int day = 1;
        int sum = 0;
        for(int x : w){
            if(sum+x > mid){
                day++;
                sum = x;
            }
            else{
                sum += x;
            }
        }
        return day <= days;
    }
}