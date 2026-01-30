class Solution {
    public int[] sortByBits(int[] arr) {
        int ans[][] = new int [arr.length][2];
        for(int i = 0 ; i < arr.length ; i++){
            ans[i][0] = arr[i];
            ans[i][1] = Integer.bitCount(arr[i]);
        }
        Arrays.sort(ans,(a,b)-> {if(a[1]==b[1]){
            return a[0]-b[0];
        }
        else{
            return a[1]-b[1];
        }});
        int res[] = new int[arr.length];
        for(int i = 0 ; i < res.length ; i++){
            res[i] = ans[i][0];
        }
        return res;
        

    }
}