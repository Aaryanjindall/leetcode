class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        // for(int i = 1 ; i < arr.length ; i++){
        //     if(arr)
        // }
        arr[0] = 1;
        for(int i = 1 ; i < arr.length ; i++){
            if(arr[i]-arr[i-1]>1){
                arr[i] = arr[i-1]+1;
            }
        }
        int max = 0;
        for(int i = 0 ; i < arr.length ; i++){
            max = Math.max(arr[i],max);
        }
        return max;

    }
}