class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder(a);
        StringBuilder sb2 = new StringBuilder(b);
        sb.reverse();
        sb2.reverse();
        int n = a.length();
        int m = b.length();
        int l = Math.max(n,m);
        int k =0;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while(k < l){
            int x = (k<n)? sb.charAt(k) - '0' : 0;
            int y = (k<m)? sb2.charAt(k) - '0' : 0;
            
            int sum = x + y + carry;
            res.append(sum%2);
            carry = sum/2;
            k++;
            
            
        }
        if(carry == 1){
            res.append('1');

        }
        return res.reverse().toString();
    }
}