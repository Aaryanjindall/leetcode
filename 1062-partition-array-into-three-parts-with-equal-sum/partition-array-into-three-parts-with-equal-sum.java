class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        boolean flag = false;
        int sum = 0;
        for(int ar : arr){
            sum += ar;
            if(ar != 0){
                flag = true;
            }
        }
        if(!flag){
            return true;
        }
        if(sum % 3 != 0){
            return false;
        }
        int tar = sum/3;
        int count = 0;
        int sumtar = 0;
        for(int i = 0 ; i < arr.length ; i++){
            sumtar += arr[i];
            if(sumtar == tar){
                count++;
                sumtar = 0;
            }
        }
        if(count >= 3){
            return true;
        }
        return false;
    }
}