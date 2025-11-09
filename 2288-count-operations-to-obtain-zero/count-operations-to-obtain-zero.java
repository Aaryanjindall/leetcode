class Solution {
    public int countOperations(int x, int y) {
        int op = 0;
        while((x != 0) && (y != 0) ){
            if(x >= y){
                x = x-y;
                // op++;
            }
            else{
                y = y-x;
                
            }
            op++;
            
        }
        return op;
    }
}