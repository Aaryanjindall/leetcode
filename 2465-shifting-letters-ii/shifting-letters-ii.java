class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int arr[] = new int[s.length()];
        for(int shift[] : shifts){
            int a = shift[0];
            int b = shift[1];
            int k = shift[2];

            arr[a] += (k == 0) ? -1 : 1;
            if(b+1 < arr.length){
                arr[b+1] -= (k == 0) ? -1 : 1;    // difference array wala concept
            }
        }
        for(int i = 1 ; i < arr.length ; i++){
            arr[i] += arr[i-1];
        }
        for(int j : arr){
            System.out.print(j);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            int shift = arr[i]%26;
            if(shift < 0)shift += 26;
            int newchar = (ch - 'a' + shift)%26 + 'a';
            sb.append((char)newchar);
        }
        return sb.toString();
    }
}