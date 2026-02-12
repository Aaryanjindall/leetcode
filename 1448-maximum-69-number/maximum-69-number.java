class Solution {
    public int maximum69Number (int num) {
        String n = Integer.toString(num);
        char []arr = n.toCharArray();
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == '6'){
                arr[i] = '9';
                String a = new String(arr);
                int ans = Integer.parseInt(a);
                if(ans > num){
                    return ans;
                }
            }
        }
        return num;
    }
}