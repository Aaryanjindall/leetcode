class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        for(int i = 0 ; i < 32 ; i++){
            int righta = ((a>>i)&1);
            int rightb = ((b>>i)&1);
            int rightc = ((c>>i)&1);
            if(rightc == 1){
                if(righta == 0 && rightb == 0){
                    flips++;
                }
            }
            else{
                if(righta == 1 && rightb == 1)flips+=2;
                if(righta == 1 && rightb == 0)flips+=1;
                if(righta == 0 && rightb == 1)flips+=1;
            }
        }
        return flips;
    }
}