class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int l = Integer.MAX_VALUE;
        int h = Integer.MIN_VALUE;
        for(int x : bloomDay){
            l = Math.min(l,x);
            h = Math.max(h,x);
        }
        if((long)m*k > bloomDay.length){
            return -1;
        }
        while(l<=h){
            int mid = l+(h-l)/2;
            if(poss(mid,bloomDay,m,k)){
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return l;
    }
    private boolean poss(int mid , int bloomDay[] , int m , int k){
        int boq = 0;
        int x = 0;
        for(int i = 0 ; i < bloomDay.length ; i++){
            if(bloomDay[i]<=mid){
                x++;
                if(x == k){
                    x = 0;
                    boq++;
                }
            }
            else{
                x = 0;
            }
        }
        return boq >= m;
    }
}