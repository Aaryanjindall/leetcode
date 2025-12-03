class Solution {
    public boolean winnerOfGame(String c) {
        int alice = 0;
        int bob = 0;
        for(int i = 1 ; i < c.length()-1 ; i++){
            if(c.charAt(i-1)== 'A' && c.charAt(i) == 'A' && c.charAt(i+1) == 'A'){
                alice++;
            }
            if(c.charAt(i-1)== 'B' && c.charAt(i) == 'B' && c.charAt(i+1) == 'B'){
                bob++;
            }

        }
        return alice > bob;
    }
}