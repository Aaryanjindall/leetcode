class Solution {
    public int commonFactors(int a, int b) {

        int x = gcd(a,b);
        int fact = 0;

        for(int i = 1 ; i*i <= x ; i++){
            if(x % i == 0){
                fact++;

                if(i != x / i){
                    fact++;
                }
            }
        }

        return fact;
    }   // ← ye missing tha

    private int gcd(int a , int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a % b);
    }
}