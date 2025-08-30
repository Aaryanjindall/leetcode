class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        for(int i = 0 ; i < 32 ; i++){
            int abit = (a & (1<<i));
            int bbit = (b & (1<<i));
            int cbit = (c & (1<<i));

        
        if(cbit == 0){
            if(abit != 0)flips++;
            if(bbit != 0)flips++;
        }
        else{
            if(abit == 0 && bbit == 0)flips++;
        }
    }
        return flips;
    }
}