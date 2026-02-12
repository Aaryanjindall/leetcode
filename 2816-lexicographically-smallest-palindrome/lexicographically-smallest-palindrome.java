class Solution {
    public String makeSmallestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        char arr[] = s.toCharArray();
        int j = s.length()-1;
        while(i<j){
            if(arr[i]>arr[j]){
                arr[i] = arr[j];
            }
            else if(arr[i]<arr[j]){
                arr[j] = arr[i];
            }
            i++;
            j--;
        }
        String ans = new String(arr);
        return ans;
    }
}