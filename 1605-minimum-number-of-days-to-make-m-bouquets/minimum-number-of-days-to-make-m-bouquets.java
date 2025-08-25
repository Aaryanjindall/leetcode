class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int l = Integer.MAX_VALUE;
        int h = Integer.MIN_VALUE;
        for(int bloom : bloomDay){
            l = Math.min(l,bloom);
            h = Math.max(h,bloom);
        }
        if(m*k > bloomDay.length){
            return -1;
        }
        int ans = -1;
        while(l <= h){
            int mid = l + (h-l)/2;
            int posdayboq = possible(bloomDay , m , k ,mid);
            if(posdayboq >= m){
                ans = mid;
                h = mid -1;
            }
            else{
                l = mid +1 ;
            }


        }
        return ans;

    }
    private int possible(int []bloomDay , int m , int k , int day){
        int count = 0;
        int numberboq = 0;
        for(int i = 0 ; i < bloomDay.length ; i++){
            if(bloomDay[i]<= day){
                count ++;
            }
            else{
                numberboq += count/k;
                count = 0;

            }
        }
        numberboq += count/k;
        return numberboq;
        
    }
}