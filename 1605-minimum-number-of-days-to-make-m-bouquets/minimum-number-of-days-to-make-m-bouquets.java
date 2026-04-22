class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int b : bloomDay){
            min = Math.min(b,min);
            max = Math.max(b,max);
        }
        if((long)m * k > bloomDay.length){
    return -1;
}
        while(min<max){
            int mid = min+(max-min)/2;
            int posboq = find(bloomDay,mid,k);
            if(posboq >= m){
                max = mid;
            }
            else{
                min = mid+1;
            }
        }
        return min;

    }
    private int find(int []arr , int mid , int k){
        int boq = 0;
        int count = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i]<=mid){
                count++;
                if(count == k){
                    boq++;
                    count = 0;
                }
            }
            else{
                count = 0;
            }
        }
        return boq;
    }
}