class Solution {
    public String reverseWords(String s){
        StringBuilder sb = new StringBuilder();
        String [] str = s.split(" ");
        for(int i = 0 ; i < str.length ; i++){
            String rev = reverse(str[i]);
            sb.append(rev);
            if(i != str.length-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    private String reverse(String st) {
        char[] arr = st.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
    }
}