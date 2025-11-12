class Solution {
    int res = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        int children[] = new int[k];
        backtrack(children,cookies,k,0);
        return res;
    }
    private void backtrack(int []children, int [] cookies , int k ,int idx){
        if(idx == cookies.length){
            int max = 0;
            for(int j : children){
                max = Math.max(j,max);
            }
            res = Math.min(max,res);
            return;
        }
        for(int i = 0 ; i < k ; i++){
            children[i] += cookies[idx];
            backtrack(children,cookies,k,idx+1);
            children[i] -= cookies[idx];
        }
    }
}