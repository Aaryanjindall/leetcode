class Solution {
    public int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean neg = (dividend < 0 ) ^ (divisor < 0);

        long dvd = Math.abs((long)dividend);
        long div = Math.abs((long)divisor);
        int result = 0;

        while(dvd >= div){
            int i = 0;
            while(dvd >= (div << i)){
                i++;
            }
            i--;
            
            dvd -= (div << i);
            result += 1 << i;

        }

        return neg? -result : result;

    }
}