class Solution {
    public int[] twoSum(int[] num, int tar){
        int i = 0;
        int j = num.length-1;
        while(i<j){
            int sum = num[i]+num[j];
            if(sum < tar){
                i++;
            }
            else if(sum >tar){
                j--;
            }
            else{
                return new int[]{i+1,j+1};
            }
        }
        return new int[]{};
    }
}