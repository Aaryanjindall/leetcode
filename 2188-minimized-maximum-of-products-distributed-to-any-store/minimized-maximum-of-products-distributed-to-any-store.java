class Solution {
    public int minimizedMaximum(int n, int[] quant) {
        int l = 1;
        int h = 0;
        if (quant.length > n) return -1;
        for(int x : quant){
            h = Math.max(h,x);
        }
        int ans = -1;
        while(l<=h){
            int mid = l +(h-l)/2;
            if(pos(n,quant,mid)){
                ans = mid;
                h = mid-1;
            }
            else{
                l = mid+1;
            }   
        }
        return ans;
    }
    private boolean pos(int n , int arr [] , int mid){
        int need = 0;
        for(int x : arr){
            need += (x+mid-1)/mid;
        }
        return need <= n;
    }
}