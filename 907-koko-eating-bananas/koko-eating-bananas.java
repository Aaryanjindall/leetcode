class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int s = 1;
        int e = 0;

        for(int p : piles){
            e = Math.max(e,p);
        }
        int ans = e;

        while(s <= e){
            int mid = s + (e-s)/2;

            long time = 0;
            for(int p : piles){
                time += (p+mid-1)/mid;
            }

            if(time <= h){
                ans = mid;
                e = mid-1;
            }
            else{
                s = mid+1;
            }
        }
        return ans;
    }
}